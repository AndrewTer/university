%Интегральные оценки качества

clear, clc

T1 = -100:1:100;
T = 100;
T2 = 0.002;
T3 = 0.03;
T4 = 0.04;
K = 7.5;

W = (K.^2)./(2*(1+K).^3) + (K.*K.*(T1*T2+T1*T3+T2*T3).^2)./(2.*((T1+T2+T3+T4).*(T1*T2+T1*T3+T2*T3)-(1+K).*(T1*T2*T3))*(1+K).^2);
plot(W);

grid on
