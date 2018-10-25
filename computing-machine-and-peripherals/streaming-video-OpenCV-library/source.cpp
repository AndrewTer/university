#include "opencv\cv.h"
#include "opencv\highgui.h"
#pragma comment(lib, "opencv_highgui231.lib")
#pragma comment(lib, "opencv_core231.lib")
#pragma comment(lib, "opencv_objdetect231.lib")
#include <iostream>

using namespace std;

CvCapture* capture = 0;
IplImage* frame = 0;

int g_slider_position = 0;
CvCapture* g_capture = NULL;

int radius = 1;
int radius_max = 255;

void onTrackbarSlide(int pos)
{
  cvSetCaptureProperty(g_capture, CV_CAP_PROP_POS_FRAMES, pos);
}

char* gsp(IplImage *image, int x, int y)
{
	return image->imageData + y*image->width*3 + x*3;
}

// функция-обработчик ползунка
void myTrackbarRadius(int pos) {
  radius = pos;
}

void Frame(IplImage *image, CvRect *r)
{
	CvPoint pt1 = { r->x, r->y };
	CvPoint pt2 = { r->x + r->width/2, r->y + r->height/2 };
	
	cvCircle(image, pt2, r->width *0.15, CV_RGB(radius, 221, 255), 3, 4, 0);
	cvCircle(image, pt2, r->width *0.25, CV_RGB(255, 125, 0), 3, 4, 0);
	cvCircle(image, pt2, r->width *0.35, CV_RGB(0, 100, 255), 3, 4, 0);
  	cvCircle(image, pt2, r->width *0.45, CV_RGB(0, 255, 255), 3, 4, 0);
  	cvCircle(image, pt2, r->width *0.55, CV_RGB(0, 23, 34), 3, 4, 0);
  	cvCircle(image, pt2, r->width *0.65, CV_RGB(0, radius, 255), 3, 4, 0);
  	cvCircle(image, pt2, r->width *0.75, CV_RGB(0, 255, 255), 3, 4, 0);
  	cvCircle(image, pt2, r->width *0.85, CV_RGB(0, 56, 12), 3, 4, 0);
  	cvCircle(image, pt2, r->width *0.95, CV_RGB(0, radius, 235), 3, 4, 0);
	cvCircle(image, pt2, 2, CV_RGB(0, 255, 255), 3, 4, 0);
}

void Invert(IplImage *image, CvRect *r)
{
	int w = r->x+r->width, h = r->y+r->height, i, j;
	for (j=r->y; j<=h-1; j++)
	{
		for (i=r->x; i<=w-1; i++)
		{
			char* p = gsp(image, i, j);
			p[0] = 0xFF - p[0];
			p[1] = 0xFF - p[1];
			p[2] = 0xFF - p[2];
		}
	}
}

void GrayScale(IplImage *image, CvRect *rn)
{
	int w = rn->x+rn->width, h = rn->y+rn->height, i, j, r, g, b;
	for (j=rn->y; j<=h-1; j++)
	{
		for (i=rn->x; i<=w-1; i++)
		{
			char *temp = gsp(image, i, j);
			r = temp[0]; g = temp[1]; b = temp[2];
			r = g = b = (unsigned char)(0.299*(double)r+0.587*(double)g+0.114*(double)b);
			temp[0] = r; temp[1] = g; temp[2] = b;
		}
	}
}

void White2(IplImage *image, CvRect *rn)
{
	int w = rn->x + rn->width, h = rn->y + rn->height, i, j;
	for (j = rn->y; j <= h - 1; j+=10)
	{
		for (i = rn->x; i <= w - 1; i+=10)
		{
			char* p = gsp(image, i, j);
			for (int k = 0; k < 10; k++)
			{
				for (int l = 0; l < 10; l++)
				{
					char* ptemp = gsp(image, i + k, j + l);
					ptemp[0] = p[0];
					ptemp[1] = p[1];
					ptemp[2] = p[2];
				}
			}
			
		}
	}
}

void Whitew(IplImage *image, CvRect *rn)
{
	int w = rn->x + rn->width, h = rn->y + rn->height, i, j;
	for (j = rn->y; j <= h - 1; j++)
	{
		for (i = rn->x; i <= w - 1; i++)
		{
			char* p = gsp(image, i, j);
			p[0] = radius;//0xFF - p[0];
			p[1] = 0x777777;//0xFF - p[1];
			p[2] = 0x444444;//0xFF - p[2];
		}
	}
}

void White(IplImage *image, CvRect *rn)
{
	int w = rn->x + rn->width/2, h = rn->y + rn->height/2, i, j;
	for (j = h - 1; j >= rn->y+5; j -= 5)
	{
		for (i = w - 1; i >= rn->x+5; i -= 5)
		{
			char* p = gsp(image, i, j);
			for (int k = 0; k < 5; k++)
			{
				for (int l = 0; l < 5; l++)
				{
					int t = 2*i - k-1;
					int t1 = 2*j -l-1;
					char* ptemp = gsp(image, t, t1);
					ptemp[0] = p[0];
					ptemp[1] = 0xFFFFFF;
					ptemp[2] = p[2];
				}
			}
		}
	}
}

int main()
{ 
	CvHaarClassifierCascade * pCascade = (CvHaarClassifierCascade*)cvLoad("haarcascade_frontalface_default.xml", 0, 0, 0);
	CvMemStorage * pStorage = cvCreateMemStorage(0);
	CvSeq *pFaceRectSeq = 0; CvRect *r = 0;

	CvCapture *capture = cvCaptureFromCAM(CV_CAP_ANY);
	IplImage *frame = 0, *image = 0;
	int key = 0, last = 3;

	CvVideoWriter *writer = cvCreateVideoWriter( // создаём файл для записи
		"new.avi",
		CV_FOURCC('F', 'L', 'V', '1'),
		60,
		cv::Size(600, 600)
	);
  
	IplImage* logpolar_frame = cvCreateImage( //  кадр в полярных координатах
		cv::Size(600, 600),
		IPL_DEPTH_8U,
		3
	);

  int frames = (int)cvGetCaptureProperty(g_capture, CV_CAP_PROP_FRAME_COUNT);
  
  int currentPosition = 0;
  if (frames != 0) {
    // показываем ползунок
    cvCreateTrackbar("Position", "original", &currentPosition, frames, onTrackbarSlide);
  }

	if (!pStorage || !pCascade || !capture)
		cout << "Initialization failed" << endl;
	else
	{
		cvNamedWindow("WebCamera", CV_WINDOW_AUTOSIZE);
    cvCreateTrackbar("Colour", "WebCamera", &radius, radius_max, myTrackbarRadius);
		
    while (key != 27)
		{
			frame = cvQueryFrame(capture);
			image = cvCloneImage(frame);
			pFaceRectSeq = cvHaarDetectObjects(image, pCascade, pStorage, 1.1, 3, CV_HAAR_DO_CANNY_PRUNING, cvSize(75, 75));
			for (int i = 0; i < (pFaceRectSeq ? pFaceRectSeq->total : 0); i++)
			{
				r = (CvRect*)cvGetSeqElem(pFaceRectSeq, i);
				switch (last)
				{
				  case '1': Frame(image, r); break;
				  case '2': White2(image, r); break;
				  case '3': Whitew(image, r); break;
				  default: break;
				}
			}
			cvShowImage("WebCamera", image);
			cvWriteFrame(writer, image);
			cvReleaseImage(&image); 
			key = cvWaitKey(1);
			if (key != -1) last = key;
		}
		cvDestroyWindow("WebCamera");
		cvReleaseCapture(&capture);
		cvReleaseHaarClassifierCascade(&pCascade);
		cvReleaseMemStorage(&pStorage);
		cvReleaseVideoWriter(&writer);
	}
}
