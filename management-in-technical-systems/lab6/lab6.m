%Выделение области устойчивости методом D-разбиения по одному параметру

w=-5000:.05:5000;
T2 = 0.002;
T3 = 0.03;
T4 = 0.04;
K = 7.5;
A =(-2*T2.^2*T3*w.^4-T2*T3.^2*w.^4-T2*T3*T4*w.^4-T4*w.^2+T2*w.^2*K+T3*w.^2*K-T2.^2*T3.^2*w.^4)./(-w.^2-T3.^2*w.^4-T2.^2*T3.^2*w.^6-T2.^2*w.^4-4*T2*T3*w.^4);
B =(T2.^2*T3.^2*w.^5-T2*T3*w.^3*K+K*w+w+T2.^2*w.^3+T2*T4*w.^3+T3.^2*w.^3+T3*T4*w.^3)./(-w.^2-T3.^2*w.^4-T2.^2*T3.^2*w.^6-T2.^2*w.^4-4*T2*T3*w.^4);
xlabel('A');ylabel('B');
plot(A, B, 'G');
grid on;
