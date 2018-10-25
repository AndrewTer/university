#include <opencv2/core/utility.hpp>
#include <opencv2/imgproc.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
#include <cstdio>
#include <iostream>
#include <conio.h>
using namespace cv;
using namespace std;

static void help()
{
	cout << "Управление: \n"
		"\tESC - выход из программы\n"
		"\tg - запустить инвертирование изображения / пороговое преобразование\n"
		"\t\t0 : Binary\n"
		"\t\t1 : Binary Inverted\n"
		"\t\t2 : Threshold Truncated\n"
		"\t\t3 : Threshold to Zero\n"
		"\t\t4 : Threshold to Zero Inverted\n"
		"\tr - восстановить исходное изображение\n"
		"\tw or SPACE - запустить сегментацию изображения\n"
		"\t(перед тем, как запустить, отметьте области для сегментации изображения)\n";
}

Mat markerMask, img;
Point prevPt(-1, -1);
int threshold_value = 0;
int threshold_type = 3;
int const max_value = 255;
int const max_type = 4;
int const max_BINARY_value = 255;
string filename_main;
Mat src, src_gray, dst;
char* window_name = "Threshold image";
char* trackbar_type = "Type";
char* trackbar_value = "Value";
void Threshold_Im(int, void*);

static void onMouse(int event, int x, int y, int flags, void*)
{
	if (x < 0 || x >= img.cols || y < 0 || y >= img.rows)
		return;
	if (event == EVENT_LBUTTONUP || !(flags & EVENT_FLAG_LBUTTON))
		prevPt = Point(-1, -1);
	else if (event == EVENT_LBUTTONDOWN)
		prevPt = Point(x, y);
	else if (event == EVENT_MOUSEMOVE && (flags & EVENT_FLAG_LBUTTON))
	{
		Point pt(x, y);
		if (prevPt.x < 0)
			prevPt = pt;
		line(markerMask, prevPt, pt, Scalar::all(255), 5, 8, 0);
		line(img, prevPt, pt, Scalar::all(255), 5, 8, 0);
		prevPt = pt;
		imshow("Original image", img);
	}
}

int main(int argc, char** argv)
{
	setlocale(LC_CTYPE, "rus");
	int select = 1;
	cout << "1 - получить и работать с изображением с веб-камеры\n2 - работать с готовым изображением\nВаш выбор: ";
	cin >> select;

	if (!cin)
	{
		cout << "Ошибка ввода!";
		_getch();
		exit(0);
	}

	if (select == 1)
	{
		VideoCapture cap(0);
		// Получение кадра с веб-камеры
		Mat save_img; cap >> save_img;
		if (save_img.empty())
		{
			std::cerr << "Ошибка в работе веб-камеры, нет возможности получить изображение!" << std::endl;
		}
		// Сохранение кадра в файл
		filename_main = "test_web.jpg";
		imwrite(filename_main, save_img);
	}
	else if (select == 2)
	{
		filename_main = "test.jpg";
	}
	else
	{
		cout << "Ошибка ввода!";
		_getch();
		exit(0);
	}

	cv::CommandLineParser parser(argc, argv, "{help h | | }{ @input | test.jpg | }");
	if (parser.has("help"))
	{
		help();
		return 0;
	}

	Mat img0 = imread(filename_main, 1), imgGray;
	if (img0.empty())
	{
		cout << "Невозможно открыть файл " << filename_main << ".\n";
		_getch();
		return 0;
	}
	help();
	namedWindow("Original image", 1);
	img0.copyTo(img);
	cvtColor(img, markerMask, COLOR_BGR2GRAY);
	cvtColor(markerMask, imgGray, COLOR_GRAY2BGR);
	markerMask = Scalar::all(0);
	imshow("Original image", img);
	setMouseCallback("Original image", onMouse, 0);
	for (;;)
	{
		int c = waitKey(0);
		if ((char)c == 27)
			exit(0);
		if ((char)c == 'r')
		{
			markerMask = Scalar::all(0);
			img0.copyTo(img);
			imshow("Original image", img);
		}

		if ((char)c == 'g')
		{
			src = imread(filename_main, 1);
			/// Конвертирование изображения в серый
			cvtColor(img, src_gray, CV_BGR2GRAY);

			/// Создание окна для отображения результатов
			namedWindow(window_name, CV_WINDOW_AUTOSIZE);

			/// Создание Trackbar для выбора типа порогового преобразования
			createTrackbar(trackbar_type,
				window_name, &threshold_type,
				max_type, Threshold_Im);

			createTrackbar(trackbar_value,
				window_name, &threshold_value,
				max_value, Threshold_Im);

			/// Вызов функции инициализации
			Threshold_Im(0, 0);
		}

		if ((char)c == 'w' || (char)c == ' ')
		{
			int i, j, compCount = 0;
			vector<vector<Point> > contours;
			vector<Vec4i> hierarchy;
			findContours(markerMask, contours, hierarchy, RETR_CCOMP, CHAIN_APPROX_SIMPLE);
			if (contours.empty())
				continue;
			Mat markers(markerMask.size(), CV_32S);
			markers = Scalar::all(0);
			int idx = 0;
			for (; idx >= 0; idx = hierarchy[idx][0], compCount++)
				drawContours(markers, contours, idx, Scalar::all(compCount + 1), -1, 8, hierarchy, INT_MAX);
			if (compCount == 0)
				continue;
			vector<Vec3b> colorTab;
			for (i = 0; i < compCount; i++)
			{
				int b = theRNG().uniform(0, 255);
				int g = theRNG().uniform(0, 255);
				int r = theRNG().uniform(0, 255);
				colorTab.push_back(Vec3b((uchar)b, (uchar)g, (uchar)r));
			}
			double t = (double)getTickCount();
			watershed(img0, markers);
			t = (double)getTickCount() - t;
			printf("Время выполнения = %gms\n", t*1000. / getTickFrequency());
			Mat wshed(markers.size(), CV_8UC3);
			// создание сегментированного изображения
			for (i = 0; i < markers.rows; i++)
				for (j = 0; j < markers.cols; j++)
				{
					int index = markers.at<int>(i, j);
					if (index == -1)
						wshed.at<Vec3b>(i, j) = Vec3b(255, 255, 255);
					else if (index <= 0 || index > compCount)
						wshed.at<Vec3b>(i, j) = Vec3b(0, 0, 0);
					else
						wshed.at<Vec3b>(i, j) = colorTab[index - 1];
				}
			wshed = wshed*0.5 + imgGray*0.5;
			imshow("Watershed image", wshed);
			imwrite("result_watershed.jpg", wshed);
		}
	}
	_getch();
	return 0;
}

void Threshold_Im(int, void*)
{
	threshold(src_gray, dst, threshold_value, max_BINARY_value, threshold_type);
	imshow(window_name, dst);
	imwrite("result_threshold.jpg", dst);
}
