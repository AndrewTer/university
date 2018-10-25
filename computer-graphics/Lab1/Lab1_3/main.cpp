/*
3D примитивы
3. Изобразить большой и малый цилиндры таким образом, чтобы один из них располагался на другом. 
Размеры и местоположение примитивов на экране задать самостоятельно.
*/
#include <stdlib.h>
#include <GL/glut.h>
#include <GL/gl.h>
#include <GL/GLU.H>
#include <GL/glaux.h>

double rotate_y = 0;
double rotate_x = 0;
double tr_x = 0;
double tr_y = 0;

void drawcylinder()
{
	GLUquadricObj * quadObj;

	// создаем новый объект для создания дисков и цилиндров

	quadObj = gluNewQuadric();

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	glPushMatrix();

	glTranslated(tr_x+0.3, 0, tr_y+0.3); // сдвиг
	

	glColor3d(0, 1, 0);

	// устанавливаем стиль: каркасный

	gluQuadricDrawStyle(quadObj, GLU_LINE);

	gluCylinder(quadObj, 0.2, 0.2, 0.5, 15, 15);  // объект, нижний радиус, верхний радиус, высота

	gluDisk(quadObj, 0, 0.2, 15, 15); // верхний диск - верх цилиндра
	glTranslatef(0, 0, 0.5);
	gluDisk(quadObj, 0, 0.2, 15, 15); // нижний диск - низ цилиндра
	glPopMatrix();

	gluDeleteQuadric(quadObj);

	////////////////////////////

	glTranslated(tr_x+0.3, 0, tr_y);

	quadObj = gluNewQuadric();

	glPushMatrix();

	glColor3d(0, 0, 1);

	// устанавливаем стиль: каркасный

	gluQuadricDrawStyle(quadObj, GLU_LINE);

	gluDisk(quadObj, 0, 0.1, 15, 15); // верхний диск - верх цилиндра
	gluCylinder(quadObj, 0.1, 0.1, 0.3, 15, 15);
	glTranslatef(0, 0, 0.3);
	gluDisk(quadObj, 0, 0.1, 15, 15); // нижний диск - низ цилиндра
	
	glPopMatrix();
	gluDeleteQuadric(quadObj);
}


void display()
{
	glClear(GL_COLOR_BUFFER_BIT);
	// Сброс трансформаций
	glLoadIdentity();

	// Вращение при изменении пользователем значений rotate_x и rotate_y
	glRotatef(rotate_x, 1.0, 0.0, 0.0);
	glRotatef(rotate_y, 0.0, 1.0, 0.0);

	// Отрисовка цилиндров
	drawcylinder();
	glFlush();  //гарантирует, что прорисовка полигона будет выполнена немедленно  
}

void specialKeys(int key, int x, int y) 
{
	switch (key)
	{
		//  Правая стрелка - увеличение вращения на 5 градусов
		case GLUT_KEY_RIGHT:
		{
			rotate_y += 5;
			break;
		}
		//  Левая стрелка - уменьшение вращения на 5 градусов
		case GLUT_KEY_LEFT:
		{
			rotate_y -= 5;
			break;
		}
		//  Верхняя стрелка - увеличение вращения на 5 градусов
		case GLUT_KEY_UP:
		{
			rotate_x += 5;
			break;
		}
		//  Нижняя стрелка - уменьшение вращения на 5 градусов
		case GLUT_KEY_DOWN:
		{
			rotate_x -= 5;
			break;
		}
		// F1 - перемещение по оси x в +
		case GLUT_KEY_F1:
		{
			tr_x += 0.1;
			break;
		}
		// F2 - перемещение по оси x в -
		case GLUT_KEY_F2:
		{
			tr_x -= 0.1;
			break;
		}
		// F3 - перемещение по оси y в +
		case GLUT_KEY_F3:
		{
			tr_y += 0.1;
			break;
		}
		// F4 - перемещение по оси y в -
		case GLUT_KEY_F4:
		{
			tr_y -= 0.1;
			break;
		}
		default:
		{
			tr_x += 0;
			tr_y += 0;
		}
	}
	//  Запрос обновления экрана
	glutPostRedisplay();
}

void main()
{
	glutInitWindowSize(650, 650);  // размер окна
	glutInitWindowPosition(350, 50); //позиция окна на экране  (точнее - позиция левого верхнего угла окна) 
	glutCreateWindow("OpenGL Lab1.3"); // название окна
	glClearColor(0.0, 0.0, 0.0, 0.0); // очистка экрана в черный цвет
	glutDisplayFunc(display); //вызывается всякий раз при перерисовке окна
	glutSpecialFunc(specialKeys); // для вращения фигур с помощью клавиш 
	glutMainLoop(); //эта функция вызывается после всех остальных - бесконечный цикл
} 
