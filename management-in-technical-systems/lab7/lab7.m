%Показатели качества переходной характеристики
clear;

%Область расположения корней характеристического уравнения
eq = [0.000064 0.001664 0.014016 0.05776 0.29008 0.924 2.02 5];
p = roots(eq)
i = 1;
sum = 0;
figure
scatter(real(p), imag(p), '*'),xlabel('Re(s)'), ylabel('Im(s)'), grid on;

for j = 1:4
   s(j) = (2.5*p(j) + 12.5)/(4*p(j)^3 + 39*p(j)^2 + 50 * p(j) + 125);
end


min = [];
maj = [];
n = -0.4044;
for t = 0:.1:10
    for j = 1:4
        sum = sum + (exp(p(j)*t))*(2.5*p(j)+12.5)/(4*p(j)^3 + 39*p(j)^2 + 50*p(j) + 125);
    end
    
    y(i) = 1 + sum;
    arg(i) = t;
    i = i + 1;
    
    maj(end+1) = exp(-0.61075*t)*(1 + 0.61075*t + 0.1867*t^2 + 0.038*t^3);
    min(end+1) = exp(-0.61075*t);
end

figure;
plot(arg, y)

figure;
plot(min)

figure;
plot(maj)
