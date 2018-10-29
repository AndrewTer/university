w = -50;

for i =  1:1000
    U(i) = (w.^2*(10-w.^2))/(5*(25*w.^4-499*w.^2+2500));
    V(i) = (w.^5-20*w.^3+100*w)/(25*w.^4-499*w.^2+2500);
    w = w + 0.1;
end;

%Амплитудно-частотная характеристика системы
figure; 
plot(U,V);
xlabel('U');
ylabel('V');
title('АЧХ');
grid on;

%Диаграмма bode
figure; 
bode(U,V);

%Вещественная характеристика U(w)
figure;
plot(U,'R');
title('U(w)');
grid on;
