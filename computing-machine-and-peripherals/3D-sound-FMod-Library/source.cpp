#include <math.h>
#include <conio.h> 
#include <stdio.h>
#include <windows.h>
#include "inc\fmod.hpp"
#include "inc\fmod_errors.h"
#include <iostream>
#include "inc\fmod.hpp"
#include "inc\fmod_dsp.h"
#include "inc\fmod_errors.h"
#pragma comment(lib, "fmodex_vc.lib")
using namespace std;

void dd3d(FMOD::System * system) 
{
	FMOD_RESULT result;
	int i = 0;
	float l = -5.0;
	float r = 5.0;
	float u = 0;

	bool up = true;

	while (true)
	{
		FMOD_VECTOR velocity = { 0.0f, 0.0f, 0.f };
		FMOD_VECTOR listenerpos = { l, u, r };
		result = system->set3DListenerAttributes(0, &listenerpos, &velocity, 0, 0);
		result = system->update();

		if (up)
		{
			l += 10;
			r -= 0.1;
		}
		else
		{
			l -= 10;
			r += 0.1;
		}

		i < 50 ? u += 0.1 : u -= 0.1;

		i++;
		if (i == 100)
		{
			up = !up;
			i = 0;
		}

		Sleep(10);
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	FMOD::System * system;
	FMOD::System_Create(&system);
	system->init(16, FMOD_INIT_NORMAL, 0);
	FMOD::Sound * sound;
	FMOD::Channel * channel = NULL;
	FMOD::DSP        *dspecho = 0;
	FMOD::DSP        *dspecho2 = 0;
	int               key = 0;
	unsigned int      version;
	FMOD_RESULT res = system->set3DSettings(100, 0.123, -0.1);
	res = system->getVersion(&version);
	if (version < FMOD_VERSION)
	{
		printf("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version, FMOD_VERSION);
		return 0;
	}
	res = system->createSound("1.mp3", FMOD_SOFTWARE, 0, &sound);
	printf("Press SPACE to paused/unpause.\n");
	printf("Press 1 to effect.\n");
  
	//printf("Press 'Esc' to quit\n");
  
	printf("\n");
	res = system->playSound(FMOD_CHANNEL_FREE, sound, false, &channel);
	res = system->createDSPByType(FMOD_DSP_TYPE_ECHO, &dspecho);
	res = system->createDSPByType(FMOD_DSP_TYPE_FLANGE, &dspecho2);
	do
	{
		if (_kbhit())
		{
			key = _getch();

			switch (key)
			{
			case ' ':
			{
				bool paused;
				channel->getPaused(&paused);
				paused = !paused;
				res = channel->setPaused(paused);
				break;
			}
			case'3':
			{
				dd3d(system);
				
				break;
			}
			case '1':
			{
				bool active;
				res = dspecho->getActive(&active);
				if (active)
				{
					res = dspecho->remove();
				}
				else
				{
					res = system->addDSP(dspecho, 0);
					res = dspecho->setParameter(FMOD_DSP_ECHO_DELAY, 50.0f);
				}
				break;
			}
			case '2':
			{
				bool active;
				FMOD::Reverb *r;
				res = system->createReverb(&r);
				FMOD_VECTOR velocity = { 0.0f, 10.0f, 0.f };
				float a = 10.0f;
				float b = 20.0f;
				system->set3DListenerAttributes(0, &velocity, 0 ,0 ,0);
				system->update();
				break;
			}
			}
		}

		system->update();

		{
			bool paused = 0;
			bool dspecho_active;
			bool dspecho_active2;
			bool dspecho_active3;
			dspecho->getActive(&dspecho_active);
			dspecho2->getActive(&dspecho_active2);
			if (channel)
			{
				res = channel->getPaused(&paused);
				if ((res != FMOD_OK) && (res != FMOD_ERR_INVALID_HANDLE) && (res != FMOD_ERR_CHANNEL_STOLEN))
				{
					std::cout << "pauseerror\n";
				}
			}
			printf("%s : echo[%c,%c] \r",
				paused ? "Paused " : "Playing",
				dspecho_active ? 'x' : ' ',
				dspecho_active2 ? 'y' : ' '
				);
		}

		Sleep(10);

	} while (key != 27);
	printf("\n");
	res = sound->release();
	res = system->close();
	res = system->release();
	return 0;
}
