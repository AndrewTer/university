#include <dshow.h>
#include <atlbase.h>
#include <initguid.h>
#include <dvdmedia.h>
#include <dmodshow.h>
#include <iostream>
#include <dmoreg.h>
#include <stdio.h>
#include <string>
#include <strmif.h>
#include <control.h>

#pragma coment (lib, "dmoguids.lib")

using namespace std;

int main() {
	ICaptureGraphBuilder2* pCaptureGraphBilder = NULL;
	bool keyEnd = false;
	string str;
	IMediaSeeking *	   pMediaSeeking;
	IGraphBuilder *    pGraphBuilder;
	IBaseFilter *    pGraphBuilder1;
	IMediaControl *    pMediaControl;
	IMediaEvent *      pMediaEvent;
	IBaseFilter* pSourceFile;
	IBaseFilter* pSourceFile1;

	IBaseFilter *testFilter;
	IMediaFilter *filter;
	
	LONGLONG curPos;
	LONGLONG stopPos;

	CoInitialize(NULL);
	char s[] = "1.avi";

	HRESULT hr = CoCreateInstance(CLSID_FilterGraph, NULL, CLSCTX_INPROC, IID_IGraphBuilder, (void**)&pGraphBuilder);
	CoCreateInstance(CLSID_FilterGraph, NULL, CLSCTX_INPROC, IID_IGraphBuilder, (LPVOID *)&pGraphBuilder);
	HRESULT hr1 = CoCreateInstance(CLSID_VideoMixingRenderer9, 0, CLSCTX_INPROC_SERVER, IID_IBaseFilter, (void**)&pGraphBuilder1);
	CoCreateInstance(CLSID_CaptureGraphBuilder2, NULL, CLSCTX_INPROC, IID_ICaptureGraphBuilder2, (void**)&pCaptureGraphBilder);
	//Получение интерфейса управления
	pGraphBuilder->QueryInterface(IID_IMediaControl, (LPVOID *)&pMediaControl);
	//Второй интерфейс управления
	pGraphBuilder->QueryInterface(IID_IMediaSeeking, (LPVOID *)&pMediaSeeking);
	//Получение интерфейса сообщений
	pGraphBuilder->QueryInterface(IID_IMediaEvent, (LPVOID *)&pMediaEvent);
	pCaptureGraphBilder->SetFiltergraph(pGraphBuilder);
	pGraphBuilder->AddSourceFilter(L"1.avi", L"", (IBaseFilter**)&pSourceFile);
	pGraphBuilder->AddSourceFilter(L"1.avi", L"AVIDraw", (IBaseFilter**)&pSourceFile1);

	pCaptureGraphBilder->RenderStream(NULL, NULL, pSourceFile, NULL, NULL);

	while (keyEnd != true) {
		cout << "Please, enter the command:\n";
		str = "";
		cin >> str;

		if (str == "play") {
			pMediaControl->Run();
		}
		if (str == "pause") {
			pMediaControl->Pause();
		}
		if (str == "stop") {
			pMediaControl->Stop();
		}
		if (str == "rate") {
			pMediaSeeking->SetRate(5);
		}
		if (str == "slow") {
			pMediaSeeking->SetRate(0.4);
		}
		if (str == "add") {
			pMediaControl->RenderFile(L"1.avi");
			pMediaControl->Stop();
			pMediaControl->Run();
		}
		if (str == "end") {
			keyEnd = true;
		}
	}
	pMediaControl->Release();
	pGraphBuilder->Release();
	CoUninitialize();
	return 0;
}
