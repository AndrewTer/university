%Определение характеристик точности САР при регулярных воздействиях

clear;
x=-1:0.1:1;
g=cos(x).^2+sin(2*x);
y=-10:1:10;
e=0.04*(-sin(2*x)./2 + cos(2*x)) + 0.002*(sin(x).^2 - 2*sin(2*x) - cos(x).^2) + 0.0008*(sin(2*x)./2 - cos(2*x));
hold on; plot(g); plot(e); xlabel('t'); legend('g(t)', 'e(t)'); hold off; grid on;
