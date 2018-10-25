/*
Задание №2. Морфинг
Морфирование готовой формы.
Взяв за основу математическое описание какого-либо стандартного объекта, изменить его форму.
- «груша»:
z’ = z + 2.5R (z/R – 0.5)2, если z > R/2
z’ = z – иначе.
*/
#include <cmath>
#include <GL/glut.h>

double rotate_y = 0;
double rotate_x = 0;

bool start = false;
float temp = 0.0f;

GLfloat x, y, z = 0, alpha, beta;       
GLfloat radius = 0.3f;
float n = 0;
void drawsphere();

void display(void) {
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	glRotatef(rotate_x, 1.0, 0.0, 0.0);
	glRotatef(rotate_y, 0.0, 1.0, 0.0);
	glColor3d(0, 0, 1);
	drawsphere();
	glutSwapBuffers();
}

void drawsphere()
{
	glBegin(GL_LINE_LOOP);
	for (alpha = 0.0; alpha < 360.0; alpha += 1)
	{
		for (beta = -90.0; beta < 90.0; beta += 1)
		{
			x = radius*cos(beta)*sin(alpha);
			y = radius*sin(beta)*sin(alpha);
			z = (radius*cos(alpha));
			if (z > radius/2)
			{
				temp = z + n*radius*pow((z/radius-0.5),2);
			}
			else
			{
				temp = z;
			}
			glVertex3f(x, y, temp);
		}
	}
	glEnd();
}

void specialKeys(unsigned char key, int x, int y) {
	switch (key)
	{
		//  увеличение вращения на 5 градусов по оси y
		case 'd':
		{
			rotate_y += 0.1;
			break;
		}
		//  уменьшение вращения на 5 градусов по оси y
		case 'a':
		{
			rotate_y -= 0.1;
			break;
		}
		//  увеличение вращения на 5 градусов по оси x
		case 'w':
		{
			rotate_x += 0.1;
			break;
		}
		//  уменьшение вращения на 5 градусов по оси x
		case 's':
		{
			rotate_x -= 0.1;
			break;
		}
		//  остановить вращение
		case '1':
		{
			rotate_x = 0;
			rotate_y = 0;
			break;
		}
		//  начало преобразования
		case '0':
		{
			start = !start;
			break;
		}
		default:
		{
			break;
		}
	}
	//  Запрос на обновление экрана
	glutPostRedisplay();
}

void TimerFunction(int value) {
	if (start) {
		if (n <= 2.5)
			n += 0.1;
	}
	else
	{
		if (n > 0)
			n -= 0.1;
	}
	glutPostRedisplay();  // перерисовывает экран
	glutTimerFunc(33, TimerFunction, temp);  //запускает таймер заново
}

void main()
{
	glutInitDisplayMode(GLUT_DEPTH | GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(650, 650);  // размер окна
	glutInitWindowPosition(350, 50); //позиция окна на экране  (точнее - позиция левого верхнего угла окна)
	glutCreateWindow("OpenGL Lab2"); // название окна
	glClearColor(0.0, 0.0, 0.0, 0.0); // очистка экрана в черный цвет
	glutDisplayFunc(display); //вызывается всякий раз при перерисовке окна
	glutIdleFunc(display);
	glutKeyboardFunc(specialKeys);
	glutTimerFunc(33, TimerFunction, temp);  //первый запуск таймера
	glutMainLoop(); //эта функция вызывается после всех остальных - бесконечный цикл
}
