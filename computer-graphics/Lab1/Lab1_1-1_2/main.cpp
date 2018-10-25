/*
3D примитивы
1. Изобразить каркасный куб и каркасный конус на нем.
2. Выполнить поворот полученных примитивов относительно начала координат на =45 вокруг оси Z, затем произвести масштабирование куба с коэффициентом 3.
*/
#include <GL/glut.h>

double rotate_y = 0;
double rotate_x = 0;
int x = 0, xx;
float n = 1, nn = 1;
void drawcube(float zoom)
{
	glTranslated(0, 0, 0); // перемещение x, y, z
	//рисуем каркасный куб
	glScalef(zoom, zoom, zoom); //	масштабирование с коэффициентом zoom
	glutWireCube(0.2);
}

void drawcone(float zoom)
{
	GLUquadricObj * quadObj;
	quadObj = gluNewQuadric();

	glPushMatrix();

	glColor3d(0, 0, 1);

	// устанавливаем стиль: каркасный

	gluQuadricDrawStyle(quadObj, GLU_LINE);

	glTranslated(0, 0, 0.1); // перемещение x, y, z

	//рисуем каркасный конус	
	glScalef(zoom, zoom, zoom);
	glutWireCone(0.1f, 0.2f, 10, 5); // 1 - ширина 2 - высота
	
	gluDisk(quadObj, 0, 0.1, 10, 5); // нижний диск - низ цилиндра

	glPopMatrix();

	gluDeleteQuadric(quadObj);
}

void display()
{
	glClear(GL_COLOR_BUFFER_BIT);

	glLoadIdentity();
	
	// Вращение при изменении пользователем значений rotate_x и rotate_y
	glRotatef(rotate_x, 1.0, 0.0, 0.0);
	glRotatef(rotate_y, 0.0, 1.0, 0.0);
	if (xx <= 45)
	{
		xx = x;
		glRotatef(-90, 1.0, 0.0, 0.0);
		glRotatef(0, 0.0, 1.0, 0.0);
		glRotatef(x, 0.0, 0.0, 1.0); //z
		drawcube(n);
		drawcone(1);
		glFlush();  //гарантирует, что прорисовка полигона будет выполнена немедленно  
	}
	else if (xx > 45)
	{
		glRotatef(-90, 1.0, 0.0, 0.0);
		glRotatef(0, 0.0, 1.0, 0.0);
		glRotatef(45, 0.0, 0.0, 1.0); //z
		drawcube(n);
		drawcone(0.33);
		if (n < 3)
		{
			n += 0.1;
		}
		glFlush();  //гарантирует, что прорисовка полигона будет выполнена немедленно  
	}
}

void specialKeys(int key, int x, int y) {
	//  Правая стрелка - увеличение вращения на 5 градусов
	if (key == GLUT_KEY_RIGHT)
		rotate_y += 1;

	//  Левая стрелка - уменьшение вращения на 5 градусов
	else if (key == GLUT_KEY_LEFT)
		rotate_y -= 1;

	//  Верхняя стрелка - увеличение вращения на 5 градусов
	else if (key == GLUT_KEY_UP)
		rotate_x += 1;

	//  Нижняя стрелка - уменьшение вращения на 5 градусов
	else if (key == GLUT_KEY_DOWN)
		rotate_x -= 1;

	//  Запрос обновления экрана
	glutPostRedisplay();
}

void TimerFunction(int value) {
	x += 1;
	glutPostRedisplay();  // перерисовывает экран
	glutTimerFunc(33, TimerFunction, x);  //запускает таймер заново
}

void main()
{
	glutInitWindowSize(650, 650);  // размер окна
	glutInitWindowPosition(350, 50); //позиция окна на экране  (точнее - позиция левого верхнего угла окна) 
	glutCreateWindow("OpenGL Lab1"); // вывод названия окна
	glClearColor(0.0, 0.0, 0.0, 0.0); // очистка экрана в черный цвет
	glutSpecialFunc(specialKeys); // для вращения фигур с помощью клавиш 
	glutDisplayFunc(display); //вызывается всякий раз при перерисовке окна
	glutTimerFunc(33, TimerFunction, x);  //первый запуск таймера
	glutMainLoop(); //эта функция вызывается после всех остальных - бесконечный цикл
}

