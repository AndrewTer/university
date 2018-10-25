//
//  main.cpp
//  lab1
//

#include <iostream>

int main()
{
    using namespace std;
    const int N = 5;
    int x[N] = {100, 150, 200, 250, 300};               // Спрос
    float p[N] = {0.25, 0.2, 0.2, 0.2, 0.15};           // Вероятность
    int firstprice = 49;                                // Цена в первом полугодии
    int secondprice = 15;                               // Цена во втором полугодии
    int onemercprice = 25;                              // Цена производства
    
    // Прибыль
    int matrix[N][N];
    int profit = 0;
    int mx[N];                                          // Мат.ожидание
    int maxmx = 0;                                      // Max мат.ожидание
    
    // Вычисление прибыли
    for (int i=0; i<N; i++)
    {
        for (int j=0; j<N; j++)
        {
            if (x[j]>x[i])
                profit = firstprice*x[i] - onemercprice*x[i];
            else
                profit = firstprice*x[j] + secondprice*(x[i]-x[j]) - onemercprice*x[i];
            matrix[i][j] = profit;
        }
    }
    
    // Вычисление мат.ожидания
    for (int i=0; i<N; i++)
    {
        int mxtemp = 0;
        for (int j=0; j<N; j++)
            mxtemp += matrix[i][j]*p[j];
        mx[i] = mxtemp;
    }
    
    printf("Спрос и вероятность:\nx:\t\t");
    for (int i=0; i<N; i++)
    {
        printf("%i\t\t", x[i]);
    }
    cout << "\np(x):\t";
    for (int i=0; i<N; i++)
    {
        printf("%.2f\t",p[i]);
    }
    printf("\n\nПрибыль(тыс.):\n\t\t");
    for (int i=0; i<N; i++)
    {
        printf("%i\t\t", x[i]);
    }
    printf("|мат.ожидание(тыс.)\n\t|___________________________________________|___________\n");
    
    for (int i=0; i<N; i++)
    {
        printf("%i\t|\t", x[i]);
        for (int j=0; j<N; j++)
        {
            printf("%4i\t",matrix[i][j]);
        }
        printf("|\t%4i\n", mx[i]);
    }
    
    // Вычисление max мат.ожидания
    maxmx = *max_element(mx, mx+N);
    
    int maxid = 0;
    
    for (int i = 0; i < N; i++)
        if (mx[i] == maxmx)
            maxid = i;
    
    printf("\nМаксимальное мат.ожидание (оптимальная прибыль, тыс.): %i", maxmx);
    printf("\nЗаказ, соответствующий оптимальной прибыли: %i\n", x[maxid]);
    return 0;
}
