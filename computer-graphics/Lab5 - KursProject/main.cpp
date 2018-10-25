#include <windows.h>
#include <GL\glut.h>
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

/*
Автор: Терехин Андрей гр.23531/21
Задание 11:
1. Эмиттер – сфера
2. Обязательные параметры: цвет
изменяется (затухает) в зависимости от
времени жизни
3. След: необязателен
4. Аттрактор: точка
*/

#ifndef M_PI
#define M_PI 3.14159265358979323846
#endif
#define	MAX_PARTICLES 3000
#define	TAIL_LENGHT	50
short step = 0;

GLuint TexId[1];
GLfloat  rx = 0;
GLfloat  ry = 0;
GLfloat  tx = 0;
GLfloat	 ty = -9;
GLfloat	 tz = 0;
GLint	 tt = 0;
GLfloat pl_x1 = 2, pl_x2 = 3, pl_y1 = 0, pl_y2 = 0, pl_z = 0.0, pl_normalx = 1.0, pl_normaly = 1.0, pl_normalz = 1.0;
float _r = 0.0, _g = 0.0, _b = 1.0;
float fading = 0.003f;

float cam_x = 0.0, cam_y = 0.0, cam_z = 12.0;
int mx, my;
bool ldown = false;
bool rdown = false;
bool showcone = true;
bool blending = true;
bool collision = true;
bool tail = false;
bool gravity = false;
bool dist_slowdown = true;
int count = 0;

GLuint	loop;						// Misc Loop Variable
GLuint	col;						// Current Color Selection
GLuint	delay;					// Rainbow Effect Delay

float height = 1, radius = 0.5, angle_max = 360, point_max = 50;
GLfloat mass_points[1100][3];
GLfloat mass_normals[1100][3];
GLfloat particle_tail[MAX_PARTICLES][TAIL_LENGHT][3];

#define DEFAULT_PARTICLE_SIZE 0.03;

typedef struct {
	float	life;					// Particle Life
	float	fade;					// Fade Speed
	float	r, g, b;			// RGB color
	float	x, y, z;			// Position
	float	dx, dy, dz;		// Direction
	float	size;					// Size

	void display() {
		float SIZE = size / 2;
		glBegin(GL_QUADS);
		// Front Face
		glTexCoord2f(0.0f, 0.0f); glVertex3f(x - SIZE, y - SIZE, z + SIZE);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(x + SIZE, y - SIZE, z + SIZE);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(x + SIZE, y + SIZE, z + SIZE);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(x - SIZE, y + SIZE, z + SIZE);
		// Back Face
		glTexCoord2f(1.0f, 0.0f); glVertex3f(x - SIZE, y - SIZE, z - SIZE);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(x - SIZE, y + SIZE, z - SIZE);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(x + SIZE, y + SIZE, z - SIZE);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(x + SIZE, y - SIZE, z - SIZE);
		// Top Face
		glTexCoord2f(0.0f, 1.0f); glVertex3f(x - SIZE, y + SIZE, z - SIZE);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(x - SIZE, y + SIZE, z + SIZE);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(x + SIZE, y + SIZE, z + SIZE);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(x + SIZE, y + SIZE, z - SIZE);
		// Bottom Face
		glTexCoord2f(1.0f, 1.0f); glVertex3f(x - SIZE, y - SIZE, z - SIZE);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(x + SIZE, y - SIZE, z - SIZE);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(x + SIZE, y - SIZE, z + SIZE);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(x - SIZE, y - SIZE, z + SIZE);
		// Right face
		glTexCoord2f(1.0f, 0.0f); glVertex3f(x + SIZE, y - SIZE, z - SIZE);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(x + SIZE, y + SIZE, z - SIZE);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(x + SIZE, y + SIZE, z + SIZE);
		glTexCoord2f(0.0f, 0.0f); glVertex3f(x + SIZE, y - SIZE, z + SIZE);
		// Left Face
		glTexCoord2f(0.0f, 0.0f); glVertex3f(x - SIZE, y - SIZE, z - SIZE);
		glTexCoord2f(1.0f, 0.0f); glVertex3f(x - SIZE, y - SIZE, z + SIZE);
		glTexCoord2f(1.0f, 1.0f); glVertex3f(x - SIZE, y + SIZE, z + SIZE);
		glTexCoord2f(0.0f, 1.0f); glVertex3f(x - SIZE, y + SIZE, z - SIZE);
		glEnd();
	};
} particles;						// структура частиц

particles particle[MAX_PARTICLES];	// массив частиц

float	slowdown = 4.0f;				// Коэф. замедления частиц
float	xspeed;
float	yspeed;
float	zspeed;

void initLighting() {
	// рассчет освещения
	glEnable(GL_LIGHTING);

	// двухсторонний расчет освещения
	glLightModelf(GL_LIGHT_MODEL_TWO_SIDE, GL_TRUE);

	// автоматическое приведение нормалей к единичной длине
	glEnable(GL_NORMALIZE);

	// инитим примитивный источник направленного света
	float ambient[] = { 0.0f, 0.0f, 0.0f, 1.0f };
	float diffuse[] = { 1.0f, 1.0f, 1.0f, 1.0f };
	float specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
	float position[] = { 0.0f, 0.0f, 1.0f, 0.0f };
	glEnable(GL_LIGHT0);
	glLightfv(GL_LIGHT0, GL_AMBIENT, ambient);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, diffuse);
	glLightfv(GL_LIGHT0, GL_SPECULAR, specular);
	glLightfv(GL_LIGHT0, GL_POSITION, position);
	glEnable(GL_COLOR_MATERIAL);
}

void displayattractor() {
	// рисуем точку
	glPointSize(10);
	glBegin(GL_POINTS);
	glColor3d(255, 0, 0);
	glVertex3d(5.2, 0, 0);
	glEnd();
}

float emiterVertexes[1100][3];
float emiterNormals[1100][3];
void sphere(double r, int nx, int ny) {
	int ix, iy;
	double x, y, z;
	int index = 0;

	for (iy = 0; iy < ny; iy++) {
		glBegin(GL_QUAD_STRIP);
		for (ix = 0; ix <= nx; ix++) {
			x = r * sin(iy * M_PI / ny) * cos(2 * ix * M_PI / nx);
			y = r * sin(iy * M_PI / ny) * sin(2 * ix * M_PI / nx);
			z = r * cos(iy * M_PI / ny);
			glNormal3f(x, y, z);        //нормаль направлена от центра
			glVertex3f(x, y, z);
			emiterVertexes[index][0] = x;
			emiterVertexes[index][1] = y;
			emiterVertexes[index][2] = z;

			emiterNormals[index][0] = x;
			emiterNormals[index][1] = y;
			emiterNormals[index][2] = z;

			index++;

			x = r * sin((iy + 1) * M_PI / ny) * cos(2 * ix * M_PI / nx);
			y = r * sin((iy + 1) * M_PI / ny) * sin(2 * ix * M_PI / nx);
			z = r * cos((iy + 1) * M_PI / ny);
			glNormal3f(x, y, z);
			glVertex3f(x, y, z);

			emiterVertexes[index][0] = x;
			emiterVertexes[index][1] = y;
			emiterVertexes[index][2] = z;

			emiterNormals[index][0] = x;
			emiterNormals[index][1] = y;
			emiterNormals[index][2] = z;
			index++;
		}
		glEnd();
	}
}

void displaySphereEmiter() {
	glBegin(GL_POINTS);
	for (int i = 0; i <= 1100; i++) {
		glNormal3f(emiterNormals[i][0], emiterNormals[i][1], emiterNormals[i][2]);
		glVertex3f(emiterVertexes[i][0], emiterVertexes[i][1], emiterVertexes[i][2]);
		glNormal3f(emiterNormals[i + 1][0], emiterNormals[i + 1][1], emiterNormals[i + 1][2]);
		glVertex3f(emiterVertexes[i + 1][0], emiterVertexes[i + 1][1], emiterVertexes[i + 1][2]);
	}
	glEnd();
}

void initSphereEmiter() {
	int ix, iy, nx = 30, ny = 30, r = 1;
	double x, y, z;
	int index = 0;

	for (iy = 0; iy < ny; iy++) {
		for (ix = 0; ix <= nx; ix++) {
			x = r * sin(iy * M_PI / ny) * cos(2 * ix * M_PI / nx);
			y = r * sin(iy * M_PI / ny) * sin(2 * ix * M_PI / nx);
			z = r * cos(iy * M_PI / ny);

			emiterVertexes[index][0] = x;
			emiterVertexes[index][1] = y;
			emiterVertexes[index][2] = z;

			emiterNormals[index][0] = x;
			emiterNormals[index][1] = y;
			emiterNormals[index][2] = z;

			index++;

			x = r * sin((iy + 1) * M_PI / ny) * cos(2 * ix * M_PI / nx);
			y = r * sin((iy + 1) * M_PI / ny) * sin(2 * ix * M_PI / nx);
			z = r * cos((iy + 1) * M_PI / ny);

			emiterVertexes[index][0] = x;
			emiterVertexes[index][1] = y;
			emiterVertexes[index][2] = z;

			emiterNormals[index][0] = x;
			emiterNormals[index][1] = y;
			emiterNormals[index][2] = z;
		}
		glEnd();
	}
}

// управляет всем выводом на экран 
void display(void) {
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glRotatef(90, 1, 0, 0);
	glPushMatrix();
	{
		glTranslatef(tx, ty, tz);
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 0, 1);
		glColor4f(0, 0, 0, 1);

		displayattractor();
		glColor4f(0, 0, 1, 1);
		glPointSize(2.5);
		displaySphereEmiter();

		glBindTexture(GL_TEXTURE_2D, TexId[0]);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE);
		for (loop = 0; loop < MAX_PARTICLES; loop++) {

			float x = particle[loop].x;
			float y = particle[loop].y;
			float z = particle[loop].z;

			glColor4f(particle[loop].r, particle[loop].g, particle[loop].b, particle[loop].life);
			particle[loop].display(); // вывод частицы на экран

			particle[loop].life -= particle[loop].fade;

			// изменение цвета частицы в зависимости от времени жизни
			if (particle[loop].b < 255)
				particle[loop].b += 1;
			else if (particle[loop].b >= 255)
				particle[loop].g += 1;
			else if (particle[loop].g >= 255)
				particle[loop].r += 1;

			particle[loop].x += particle[loop].dx;
			particle[loop].y += particle[loop].dy;
			particle[loop].z += particle[loop].dz;

			// воскрешение
			if (particle[loop].life<0.0f) {
				int numb = rand() % 1100;
				particle[loop].life = 10.0f;
				particle[loop].fade = float(rand() % 100) / 1000.0f + fading;
				particle[loop].size = DEFAULT_PARTICLE_SIZE;

				particle[loop].x = emiterVertexes[numb][0];
				particle[loop].y = emiterVertexes[numb][1];
				particle[loop].z = emiterVertexes[numb][2];

				particle[loop].dx = emiterNormals[numb][0] * float((rand() % 100) / 1000 + 0.001);
				particle[loop].dy = emiterNormals[numb][1] * float((rand() % 100) / 1000 + 0.001);
				particle[loop].dz = emiterNormals[numb][2] * float((rand() % 100) / 1000 + 0.001);

				particle[loop].r = _r;
				particle[loop].g = _g;
				particle[loop].b = _b;
			}

			/*
			// рисуем точки для определения пространств
			glPointSize(10);
			glBegin(GL_POINTS);
			glColor3d(0, 1, 0);
			glVertex3d(2, -2, 2);
			glVertex3d(5, -2, 2);
			glVertex3d(2, 2, 2);
			glVertex3d(5, 2, 2);
			glVertex3d(2, -2, -2);
			glVertex3d(5, -2, -2);
			glVertex3d(2, 2, -2);
			glVertex3d(5, 2, -2);
			glEnd();
			*/

			// условие в случае достижения определённых координат
			if (particle[loop].x >= 2 && particle[loop].x < 5 && particle[loop].y >= -2 && particle[loop].y < 2
				&& particle[loop].z >= -2 && particle[loop].z < 2)
			{
				particle[loop].x += 3 * pl_normalx*particle[loop].dx;
				if (particle[loop].z < 0)
					particle[loop].z -= 3 * pl_normalz*particle[loop].dz;
				if (particle[loop].z > 0)
					particle[loop].z -= 3 * pl_normalz*particle[loop].dz;
				if (particle[loop].y > 0)
					particle[loop].y -= 3 * pl_normaly*particle[loop].dy;
				if (particle[loop].y < 0)
					particle[loop].y -= 3 * pl_normaly*particle[loop].dy;
				if ((particle[loop].x >= 4.8))
					particle[loop].life = -1.0f;
			}
		}

		glDisable(GL_BLEND);
		glDisable(GL_TEXTURE_2D);
	}
	glPopMatrix();
	glutSwapBuffers();
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

void winInit() {
	glEnable(GL_DEPTH_TEST);
	glClearColor(0.0, 0.0, 0.0, 1);
	glEnable(GL_NORMALIZE);
	glMatrixMode(GL_PROJECTION);
	gluPerspective(89.0, 1.0, 0.5, 100.0);
	glMatrixMode(GL_MODELVIEW);

	initSphereEmiter();

	//Инициализация частиц
	for (loop = 0; loop<MAX_PARTICLES; loop++) {
		particle[loop].life = 1.0f;
		particle[loop].fade = float(rand() % 100) / 1000.0f + fading;
		particle[loop].size = DEFAULT_PARTICLE_SIZE;
		particle[loop].r = 0;
		particle[loop].g = 0;
		particle[loop].b = 1;
		particle[loop].dx = 0;
		particle[loop].dy = 0;
		particle[loop].dz = 0;
	}
	glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
	glHint(GL_POINT_SMOOTH_HINT, GL_NICEST);
};

void Redraw(void)
{
	glutPostRedisplay();
}

void reshape(int w, int h)
{
	glViewport(0, 0, w, h);

	// задаем матрицу проекции с учетом размеров окна 
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();

	gluPerspective(
		40.0, // угол зрения в градусах 
		(GLdouble)w / h, // коэффициент сжатия окна
		1, 100.0);  // расстояние до плоскостей отсечения по глубине
	glMatrixMode(GL_MODELVIEW);

	glLoadIdentity();
	gluLookAt(
		cam_x, cam_y, cam_z, // положение камеры 
		0.0f, 0.0f, 0.0f, // центр сцены 
		0.0f, 0.1f, 0.0f); // положительное направление оси y

}
void Mouse(int button, int state, int x, int y)
{
	if (button == GLUT_LEFT_BUTTON)
	{
		switch (state)
		{
		case GLUT_DOWN:
			ldown = true;
			mx = x;
			my = y;
			break;
		case GLUT_UP:
			ldown = false;
			break;
		}
	}
	if (button == GLUT_RIGHT_BUTTON)
	{
		switch (state)
		{
		case GLUT_DOWN:
			rdown = true;
			mx = x;
			my = y;
			break;
		case GLUT_UP:
			rdown = false;
			break;
		}
	}
}

void MouseMotion(int x, int y)
{
	if (ldown)
	{
		rx += 0.5*(y - my);
		ry += 0.5*(x - mx);
		mx = x;
		my = y;
		glutPostRedisplay();
	}
	if (rdown)
	{
		tx += 0.01*(x - mx);
		if (tt)
			tz += 0.01*(y - my);
		else
			ty += 0.01*(my - y);
		mx = x;
		my = y;
		glutPostRedisplay();
	}
}

int main(int argc, char **argv) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
	glutInitWindowPosition(150, 0);
	glutInitWindowSize(1100, 650);
	glutCreateWindow("Lab5 Var11");
	winInit();
	initLighting();
	glutIdleFunc(Redraw);
	glutReshapeFunc(reshape);
	glutDisplayFunc(display);
	glutMouseFunc(Mouse);
	glutMotionFunc(MouseMotion);
	glutMainLoop();
	return 0;
}
