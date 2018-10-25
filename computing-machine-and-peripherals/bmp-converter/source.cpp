#include <windows.h>
#include <iostream>
#include <string>

using namespace std;

void main()
{
	string sFileName;
	BITMAPFILEHEADER bmpFileHeader;
	BITMAPINFOHEADER bmpInfoHeader;
	int Width, Height;
	RGBQUAD Palette[256];
	RGBTRIPLE *inBuf;
	BYTE *outBuf;
	HANDLE hInputFile, hOutFile;
	DWORD RW;

	//cout << "Enter the full name, please: ";
	//cin >> sFileName;
	sFileName = "b.bmp";

	hInputFile = CreateFile(sFileName.c_str(), GENERIC_READ, FILE_SHARE_READ, NULL, OPEN_EXISTING, 0, NULL);
	if (hInputFile == INVALID_HANDLE_VALUE)
		return;

	hOutFile = CreateFile("Result.bmp", GENERIC_WRITE, 0, NULL, CREATE_NEW, 0, NULL);
	if (hOutFile == INVALID_HANDLE_VALUE) 
	{
		CloseHandle(hInputFile);
		return;
	}
	// считываем инфу
	ReadFile(hInputFile, &bmpFileHeader, sizeof(bmpFileHeader), &RW, NULL);
	ReadFile(hInputFile, &bmpInfoHeader, sizeof(bmpInfoHeader), &RW, NULL);

	// установим указатель на начало растра
	SetFilePointer(hInputFile, bmpFileHeader.bfOffBits, NULL, FILE_BEGIN);
	Width = bmpInfoHeader.biWidth;
	Height = bmpInfoHeader.biHeight;

	// выделим память
	inBuf = new RGBTRIPLE[Width];
	outBuf = new BYTE[Width];

	// заполним заголовки
	bmpFileHeader.bfOffBits = sizeof(bmpFileHeader) + sizeof(bmpInfoHeader);
	bmpInfoHeader.biBitCount = 8;
	bmpFileHeader.bfSize = bmpFileHeader.bfOffBits + sizeof(Palette) + Width * Height;

	// запишем заголовки
	WriteFile(hOutFile, &bmpFileHeader, sizeof(bmpFileHeader), &RW, NULL);
	WriteFile(hOutFile, &bmpInfoHeader, sizeof(bmpInfoHeader), &RW, NULL);
	// палитра черно-белая
	// палитра
	int i = 0;
	for (int R = 0; R < 256; R += 32) {
		for (int G = 0; G < 256; G += 32) {
			for (int B = 0; B < 256; B += 64) {
				Palette[i].rgbBlue = B;
				Palette[i].rgbGreen = G;
				Palette[i].rgbRed = R;
				i++;
			}
		}
	}

	WriteFile(hOutFile, Palette, 256 * sizeof(RGBQUAD), &RW, NULL);

	for (int i = 0; i < Height; i++) {
		ReadFile(hInputFile, inBuf, sizeof(BYTE) * Width * 3, &RW, NULL);

		for (int j = 0; j < Width; j++) {
			BYTE red = (inBuf[j].rgbtRed / 32) << 5;
			BYTE green = (inBuf[j].rgbtGreen / 32) << 2;
			BYTE blue = (inBuf[j].rgbtBlue / 64);

			outBuf[j] = red + green + blue;
		}

		WriteFile(hOutFile, outBuf, sizeof(BYTE) * Width, &RW, NULL);
	}

    	delete[] inBuf;
    	delete[] outBuf;
    	CloseHandle (hInputFile);
    	CloseHandle (hOutFile);

	cout << "Updating has come to the end successfully! \n";
	system("pause");
}
