/*
Текстуры. Освещение.
- Целью данной работы является ознакомление и получение навыков работы с функциями API, 
описывающими параметры источника света и свойства материалов объектов.
- Требуется разработать программу, изображающую заданный набор текстурированных предметов 
с указанными свойствами материала и позволяющую менять параметры источника света: местоположение, интенсивность, цвет
- Изменения могут происходить в автоматическом режиме (обеспечить плавность) или по щелчку мыши,
а также при помощи интерфейса (не допускается внесение изменений в код программы с целью изменить параметр источника).

Задание 11.
1. Предметы: куб, вокруг него сфера(прозрачность 0,5), конус(с зеркальностью).
2. Источники: 3, точечные, цветные.
3. Наложить текстуры на объекты.
4. Показать поочередное перемещение источников света.
*/
#include <GL/glut.h>

GLfloat angle = 0;
bool rotateShapes = false;
bool rotateLight1 = false;
bool rotateLight2 = false;
bool rotateLight3 = false;
double x1 = -1.0, y1 = -0.5, z1 = 1.0,
       x2 = 1.0, y2 = 1.0, z2 = 1.0,
       x3 = -0.5, y3 = 0.5, z3 = 0.5;

void init() {
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glShadeModel(GL_SMOOTH);
	glEnable(GL_LIGHTING);
	glEnable(GL_DEPTH_TEST);
}

void display(void) 
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	if (rotateShapes) 
  	{
		if (angle <= 180) 
    		{
			angle++;
		}
		else 
    		{
			angle = -180;
		}
	}

	if (rotateLight1) 
  	{
		if (x1 < 1.0)
			x1 += 0.01;
      
		if (y1 < 1.0)
			y1 += 0.01;
	}
  	else
  	{
		if (x1 > -1.0)
			x1 -= 0.01;

		if (y1 > -0.5)
			y1 -= 0.01;
	}

	if (rotateLight2) 
  	{
		if (x2 < 1.0)
			x2 += 0.01;

		if (y2 < 1.0)
			y2 += 0.01;
	}
	else 
  	{
		if (x2 > -1.0)
			x2 -= 0.01;

		if (y2 > 0.0)
			y2 -= 0.01;
	}

	if (rotateLight3) 
  	{
		if (x3 < 1.0)
			x3 += 0.01;

		if (y3 > -0.5)
			y3 -= 0.01;
	}
  	else 
  	{
		if (x3 > -0.5)
			x3 -= 0.01;

		if (y3 < 0.5)
			y3 += 0.01;
	}

	//точечные цветные источники света
	glPushMatrix();
	GLfloat light0_position[] = { x1, y1, z1, 1.0 };
	GLfloat light0_color[] = { 0.0, 1.0, 0.0, 0.0 };
	glLightfv(GL_LIGHT0, GL_POSITION, light0_position);
	glLightfv(GL_LIGHT0, GL_DIFFUSE, light0_color);
	glLightfv(GL_LIGHT0, GL_SPECULAR, light0_color);
	glEnable(GL_LIGHT0);
	glPopMatrix();

	glPushMatrix();
	GLfloat light1_position[] = { x2, y2, z2, 0.0 };
	GLfloat light1_color[] = { 1.0, 0.0, 0.0, 0.0 };
	glLightfv(GL_LIGHT1, GL_POSITION, light1_position);
	glLightfv(GL_LIGHT1, GL_DIFFUSE, light1_color);
	glLightfv(GL_LIGHT1, GL_SPECULAR, light1_color);
	glEnable(GL_LIGHT1);
	glPopMatrix();

	glPushMatrix();
	GLfloat light2_position[] = { x3, y3, z3, 0.0 };
	GLfloat light2_color[] = { 0.0, 0.0, 1.0, 0.0 };
	glLightfv(GL_LIGHT2, GL_POSITION, light2_position);
	glLightfv(GL_LIGHT2, GL_DIFFUSE, light2_color);
	glLightfv(GL_LIGHT2, GL_SPECULAR, light2_color);
	glEnable(GL_LIGHT2);
	glPopMatrix();
	
	// куб
	glPushMatrix();
	glRotatef(15.0, 1.0, 1.0, 0.0);
	glRotatef(angle, 0.0, 1.0, 0.0);
	glScaled(1.5, 1.5, 1.5);
	glutSolidCube(0.2);
	glScaled(1, 1, 1);
	glPopMatrix();
	
	//полупрозрачная сфера
	glPushMatrix();
	glRotatef(15.0, 1.0, 1.0, 0.0);
	glRotatef(30.0, 0.0, 1.0, 0.0);
	glEnable(GL_BLEND);
	glBlendFunc(GL_SRC_ALPHA, GL_ONE);
	glRotated(angle, 0, 1, 1);
	glutSolidSphere(0.3, 50, 25);
	glPopMatrix();

	// конус(с зеркальностью)
	glPushMatrix();
	GLfloat mat_specular[] = { 1.0, 1.0, 1.0, 1.0 };
	GLfloat mat_shininess[] = { 50.0 };
	glRotatef(angle, 0.0, 1.0, 0.0);
	glRotatef(25.0, 1.0, 1.0, 0.0);
	glTranslated(0, 0, -0.5);
	glMaterialfv(GL_FRONT_AND_BACK, GL_SPECULAR, mat_specular);
	glMaterialfv(GL_FRONT_AND_BACK, GL_SHININESS, mat_shininess);
	glutSolidCone(0.9f, 1.6f, 50, 25);
	glPopMatrix();

	glutSwapBuffers();
}

void specialKeys(unsigned char key, int x, int y) 
{
	switch (key)
	{
	case '0':
		rotateShapes = !rotateShapes;
		break;
	case '1':
		rotateLight1 = !rotateLight1;
		break;
	case '2':
		rotateLight2 = !rotateLight2;
		break;
	case '3':
		rotateLight3 = !rotateLight3;
		break;
	default:
		break;
	}
}

void reshape(int w, int h)
{
	glViewport(0, 0, (GLsizei)w, (GLsizei)h);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
  
	if (w < h)
		glOrtho(-1.5, 1.5, -0.5*(GLfloat)h / (GLfloat)w, 0.5*(GLfloat)h / (GLfloat)w, -10.0, 10.0);
	else
		glOrtho(-1.5*(GLfloat)w / (GLfloat)h, 1.5*(GLfloat)w / (GLfloat)h, -1.5, 1.5, -10.0, 10.0);
    
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

int main(int argc, char **argv) 
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(800, 800);
	glutInitWindowPosition(50, 50);
	glutCreateWindow("OpenGL Lab3");
	init();
	glutDisplayFunc(display);
	glutIdleFunc(display);
	glutReshapeFunc(reshape);
	glutKeyboardFunc(specialKeys);
	glutMainLoop();
	return 0;
}
