program Lab2
      integer i
      real x

      call decompsolve(1.0)
      call decompsolve(0.1)
      call decompsolve(0.01)
      call decompsolve(0.0001)
      call decompsolve(0.000001)
      
      write(*,*) "=========================================================================="
      
      contains

      subroutine decompsolve(p)
         implicit none
         real, intent(in) :: p
         real, dimension(8) :: b,b1,z,z1,w,w1,atb,ab
         real, dimension(8,8) :: a,a1,at,ata,x1
         integer, dimension(8) :: ni,ma,ip,ip1
         integer i,j
         real cond, c, cond1, p1, norma1, norma2, bbb
         
         a(1,1) = p-3
         a(1,2) = -4
         a(1,3) = -4
         a(1,4) = 7
         a(1,5) = 2
         a(1,6) = 3
         a(1,7) = 8
         a(1,8) = 7
         
         a(2,1) = 0
         a(2,2) = -15
         a(2,3) = -1
         a(2,4) = 5
         a(2,5) = -3
         a(2,6) = 6
         a(2,7) = 6
         a(2,8) = -6
         
         a(3,1) = -4
         a(3,2) = 2
         a(3,3) = -16
         a(3,4) = 7
         a(3,5) = 0
         a(3,6) = 8
         a(3,7) = -7
         a(3,8) = 6
         
         a(4,1) = 0
         a(4,2) = 8
         a(4,3) = -5
         a(4,4) = -11
         a(4,5) = 1
         a(4,6) = 0
         a(4,7) = 4
         a(4,8) = 5
         
         a(5,1) = 8
         a(5,2) = 6
         a(5,3) = -8
         a(5,4) = 4
         a(5,5) = 27
         a(5,6) = -7
         a(5,7) = -1
         a(5,8) = 5
         
         a(6,1) = -4
         a(6,2) = -2
         a(6,3) = 1
         a(6,4) = 2
         a(6,5) = -8
         a(6,6) = 10
         a(6,7) = 7
         a(6,8) = 0
         
         a(7,1) = 0
         a(7,2) = -1
         a(7,3) = 5
         a(7,4) = 2
         a(7,5) = -8
         a(7,6) = 2
         a(7,7) = -2
         a(7,8) = 0
         
         a(8,1) = 0
         a(8,2) = -8
         a(8,3) = -7
         a(8,4) = 3
         a(8,5) = -7
         a(8,6) = -4
         a(8,7) = -8
         a(8,8) = 5
         
         b(1) = 2*p+54
         b(2) = -72
         b(3) = -33
         b(4) = -15
         b(5) = 180
         b(6) = -5
         b(7) = -14
         b(8) = -131
                                             
         a1 = a
         b1 = b
         
         call transponmatr(8,a1,at)
         call umatm(8,8,8,at,a1,ata)
         call umatv(8,8,1,at,b1,atb)
         call decomp(8,8,a,cond,ip,w)
         
         write(*,*) "=========================================================================="
         print 111, cond
         111 FORMAT(' Cond = ', F20.2)
         write(*,*) "   Solution"
         call solve(8,8,a,b,ip)
         
         do i = 1, 8
             print 112, i, b(i)
         end do
         
         112 FORMAT(' X[', I1, ']=', F9.5)
         
         call decomp(8,8,ata,cond1,ip1,w1)
         
         print 113, cond1
         113 FORMAT(' Cond1 = ', F20.2)
         write(*,*) "  Solution"
         
         call solve(8,8,ata,atb,ip1)
         
         do i = 1, 8
             print 114, i, atb(i)
         end do
         
         114 FORMAT(' X[', I1, ']=', F9.5)
         
         call vchtv(8,b,atb,ab)
         call vnorma(8,ab,norma1)
         call vnorma(8,atb,norma2)
         
         bbb = norma1/norma2
         
         write(*,*)
         print 115, bbb
         115 FORMAT(' BBB = ', F9.5)
         write(*,*)
      end subroutine decompsolve

      subroutine vnorma(n, a, max)
         implicit none
         integer :: n
         real :: max
         real :: a(n)
         integer i
         
         max = abs(a(1))

         do i = 1, n
             if(abs(a(i))>max) then 
                 max = abs(a(i))
             endif
         end do
      end subroutine vnorma
      
      subroutine transponmatr(n, AA, BB)
          implicit none
          integer :: n
          real :: AA(n,n)
          real :: BB(n,n)
          integer i,j
          real Summa,x
          
          BB = AA
          
          do i = 1,n
              do j = i+1,n
                  x = BB(i,j)
                  BB(i,j) = BB(j,i)
                  BB(j,i) = x
              end do
          end do      
      end subroutine transponmatr
      
      subroutine umatm(nn,kk,mm,AA,BB,CC)
          implicit none
          integer :: nn, kk, mm
          real :: AA(nn,kk),BB(kk,mm),CC(nn,mm)
          integer ii, jj, ll
          real Summa
          
          do ii = 1, nn
              do jj = 1, mm
                  Summa = 0
                  do ll = 1, kk
                      Summa = Summa + AA(ii,ll)*BB(ll,jj)
                  end do
                  CC(ii,jj) = Summa
              end do
          end do   
      end subroutine umatm
      
      subroutine umatv(nn,kk,mm,AA,BB,CC)
          implicit none
          integer :: nn, kk, mm
          real :: AA(nn, mm), BB(kk), CC(nn)
          integer ii, jj, ll
          real Summa
          
          do ii = 1, nn
              do jj = 1, mm
                  Summa = 0
                  do ll = 1, kk
                      Summa = Summa + AA(ii,ll)*BB(ll)
                  end do
                  CC(ii) = Summa
              end do
          end do
      end subroutine umatv
      
      subroutine vchtv(n, a, b, c)
          implicit none
          integer, intent(in) :: n
          real :: a(n), b(n), c(n)
          integer i
          
          do i = 1, n
              c(i) = a(i) - b(i)
          end do
      end subroutine vchtv
end program lab2
