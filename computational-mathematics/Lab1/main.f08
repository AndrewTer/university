program Lab1

      integer NOFUN
      real :: A = 1.0, B = 2.0, ABSERR = 0.0, RELERR = 1.0E-6, RES,ERREST,FLAG,x
      integer i, j, k
      integer, parameter :: N=7, NN = 19
      real :: B1(NN),C1(NN),D1(NN), valX(N), valY(N)
      real SplRes, LPRes, x_k
      
      real:: XArr(N) = (/-1.,-0.960,-0.860,-0.790,0.220,0.500,0.930/)
      real:: YArr(N) = (/-1.,-0.151,0.894,0.986,0.895,0.500,-0.306/)
      
      write(*,*) "=========================================================================="
      write(*,*) "                         QUANC8 - ИНТЕГРАЛ"
      write(*,*) "--------------------------------------------------------------------------"
      
      call QUANC8(quancF,A,B,ABSERR,RELERR,RES,ERREST,NOFUN,FLAG)

      write(*,*) " A     B     RESULT    ERREST    FLAG     NOFUN "
      write(*, "(f4.1, f6.1, f10.4, f10.4, f10.4, i8)") A, B, res, errest, flag, nofun

      call SPLINE(N,XArr,YArr,B1,C1,D1)
      
      write(*,*) "=========================================================================="
      write(*,*) 
      write(*,*) "=========================================================================="
      write(*,*) " ПОЛИНОМ ЛАГРАНЖА И СПЛАЙН-ФУНКЦИЯ В ТОЧКАХ Xk = -1 +0.1k  (k=1,2,...,19) "
      write(*,*) "--------------------------------------------------------------------------"
      write(*,*) "   k      Xk        SplineRes     LagrangeRes"
      do k = 0, NN+1
      x_k = -1 + 0.1*k
      
      LPRes = PolyLagr(N, XArr, YArr, x_k)
      SplRes = SEVAL(N, x_k, XArr, YArr, B1, C1, D1)
      write(*,"(i5, f9.2, f15.5, f15.5)") k, x_k, SplRes, LPRes
      end do

      contains
      
      real FUNCTION quancF(X)
        real X
        quancF=((TAN(X))/X)
        RETURN
      END function quancF

      real FUNCTION PL(x, xk, xs, j, N)
        integer j, N
        real x, xk, xs(N)
        integer i
        PL = 1
        
        do i = 0, N
            if (i /= j) then
                PL = PL * (x - xs(i)) / (xk - xs(i))
            end if
        end do 
        return
      END function PL

      real FUNCTION PolyLagr(N, X, Y, XK)
        integer N
        real X(N), Y(N), XK
        integer i
        PolyLagr = 0
        
        do i = 0, N
            PolyLagr = PolyLagr + Y(i) * PL(XK, X(i), X, i, N)
        end do
        return
      END function PolyLagr
      

      REAL FUNCTION SEVAL(N,U,X,Y,B,C,D)
      INTEGER N
      REAL U,X(N),Y(N),B(N),C(N),D(N)
!
!     ЭTA ПOДПPOГPAMMA BЫЧИCЛЯET ЗHAЧEHИE KУБИЧECKOГO
!     CПЛAЙHA
!
!     SEVAL=Y(I)+B(I)*(U-X(I))+C(I)*(U-X(I))**2+
!                 D(I)*(U-X(I))**3
!
!     ГДE X(I).LT.U.LT.X(I+1). ИCПOЛЬЗУETCЯ CXEMA
!     ГOPHEPA
!
!     ECЛИ U.LT.X(1), TO БEPETCЯ ЗHAЧEHИE I=1.
!     ECЛИ U.GE.X(N), TO БEPETCЯ ЗHAЧEHИE I=N.
!
!     BXOДHAЯ ИHФOPMAЦИЯ.
!
!        N     -ЧИCЛO ЗAДAHHЫX TOЧEK
!        U     -AБCЦИCCA, ДЛЯ KOTOPOЙ BЫЧИCЛЯETCЯ ЗHAЧEHИE
!               CПЛAЙHA
!        X,Y   -MACCИBЫ ЗAДAHHЫX AБCЦИCC И OPДИHAT
!        B,C,D -MACCИBЫ KOЭФФИЦИEHTOB CПЛAЙHA, BЫЧИCЛEHHЫE
!               ПOДПPOГPAMMOЙ SPLINE
!
!     ECЛИ ПO CPABHEHИЮ C ПPEДЫДУЩИM BЫЗOBOM U HE
!     HAXOДИTCЯ B TOM ЖE ИHTEPBAЛE, TO ДЛЯ PAЗЫCKAHИЯ
!     HУЖHOГO ИHTEPBAЛA ПPИMEHЯETCЯ ДBOИЧHЫЙ ПOИCK.
!
      INTEGER I,J,K
      REAL DX
      DATA I/1/
      IF(I.GE.N) I=1
      IF(U.LT.X(I)) GO TO 10
      IF(U.LE.X(I+1)) GO TO 30
!
!  ДBOИЧHЫЙ ПOИCK
!
 10   I=1
      J=N+1
 20   K=(I+J)/2
      IF(U.LT.X(K))J=K
      IF(U.GE.X(K))I=K
      IF(J.GT.I+1)GO TO 20
!
!  BЫЧИCЛИTЬ CПЛAЙH
!
 30   DX=U-X(I)
      SEVAL=Y(I)+DX*(B(I)+DX*(C(I)+DX*D(I)))
      RETURN
      END

end program lab1
