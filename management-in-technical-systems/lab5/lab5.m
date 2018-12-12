%Критерий Найквиста

w=-500;
K = 7.5;
%K = 15;
%K = 91.9619097;
T1 = 0.14;
T2 = 0.002;
T3 = 0.03;
 
for i=1:50000
    s = 1i * w;
    % Передаточная функция разомкнутой системы
    R(i) = K / ((T1*s + 1) * (T2*s + 1) * (T3*s + 1));
    % Передаточная функция замкнутой системы
    Q(i) = R(i) / (1 + R(i)); 
    U(i)=real(R(i));
    V(i)=imag(R(i));
    
    w=w + 0.1;
end
figure
plot(U, V, 'b'),title('Nyquist Diagram'),xlabel('Real Axis'),ylabel('Imaginary Axis'), hold on;
plot(-1, 0, 'r', 'LineStyle', 'none', 'Marker', 'o', 'MarkerSize', 5), grid on;
clear;
