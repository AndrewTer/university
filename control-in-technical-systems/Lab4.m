%T = 0.4
%T = 0.05
T = 0.06289;
Re = [];
Im = [];
 
for w=0:0.01:1000
    Njw = 0.03 * T * ((w*i)^4) + (0.03 + 0.36 * T) * ((w*i)^3) + (0.03 + 21 * T) * ((w*i)^2) + (1 + 44.0 * T) * (w*i) + 87;
    Re(end+1) = real(Njw);
    Im(end+1) = imag(Njw);
end
 
plot(Re, Im), xlabel('Re(W)'), ylabel('Im(W)'), grid on
 
D = [0.03 * T, 0.03 + 0.36 * T, 0.03 + 21 * T, 1 + 44.0 * T, 87];
disp(roots(D));
 
figure
H=tf(87, D);
margin(H);
