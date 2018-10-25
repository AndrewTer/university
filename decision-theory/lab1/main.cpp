//
//  main.cpp
//  lab1
//

#include <iostream>

using namespace std;

int calcmm(int mas[], int rows, int columns)
{
    int result;
    int mas_min_elements[rows];
    
    // Находим минимальный элемент каждой строки
    for (int i = 0; i < rows; i++)
    {
        mas_min_elements[i] = mas[i * columns + 0];
        for (int j = 0; j < columns; j++)
        {
            if (mas[i * columns + j] < mas_min_elements[i])
                mas_min_elements[i] = mas[i * columns + j];
        }
    }
    
    // Находим максимальный элемент из минимальных элементов каждой строки
    result = *max_element(mas_min_elements, mas_min_elements+rows);
    return result;
}

int calcs(int mas[], int rows, int columns)
{
    int maxel[columns];
    int tempmatrix[rows][columns];
    
    // Находим максимальный элемент каждого столбца
    for (int j = 0; j < columns; j++)
    {
        maxel[j] = mas[0 + j];
        for (int i = 1; i < rows; i++)
        {
            if (mas[i*columns + j] > maxel[j])
                maxel[j] = mas[i*columns + j];
        }
    }
    
    // Записываем во временную матрицу разницу максимального элемента столбца и каждого элемента матрицы
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < columns; j++)
        {
            tempmatrix[i][j] = maxel[j] - mas[i*columns + j];
        }
    }
    
    // Находим минимальный элемент из максимальных элементов каждой строки временной матрицы
    int tempmaxel[rows];
    for (int i = 0; i < rows; i++)
    {
        tempmaxel[i] = tempmatrix[i][0];
        for (int j = 0; j < columns; j++)
        {
            if (tempmaxel[i] < tempmatrix[i][j])
                tempmaxel[i] = tempmatrix[i][j];
        }
    }
    
    return *min_element(tempmaxel, tempmaxel+rows);
}

float calchw(int mas[], int rows, int columns, float c)
{
    float mass[rows];
    float maxel, minel;
   
    // Получаем массив элементов, полученных путём сложения минимального и максимального элементов
    // строки матрицы, умноженных соответственно на значение (c) и (1-c)
    for (int i = 0; i < rows; i++)
    {
        maxel = mas[i * columns + 0];
        minel = mas[i * columns + 0];
        for (int j = 0; j < columns; j++)
        {
            if (mas[i * columns + j] < minel)
                minel = mas[i * columns + j];
            if (mas[i * columns + j] > maxel)
                maxel = mas[i * columns + j];
        }
        mass[i] = minel*c+maxel*(1-c);
    }
    
    // Находим максимальный элемент массива mass
    maxel = mass[0];
    for (int i = 0; i < rows; i++)
    {
        if (mass[i] > maxel)
            maxel = mass[i];
    }

    return maxel;
}

int main() {
    const int N = 4, NN = 5;
    int matrixd[N][NN] = {{15,10,0,-6,17},{3,14,8,9,2},{1,5,14,20,-3},{7,19,10,2,0}};
    float c = 0.55;
    int mm;
    int s;
    float hw;
    
    mm = calcmm(reinterpret_cast<int *>(matrixd),N,NN);
    s = calcs(reinterpret_cast<int *>(matrixd),N,NN);
    hw = calchw(reinterpret_cast<int *>(matrixd),N,NN,c);
    
    printf("Таблица доходов:\n");
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < NN; j++)
        {
            printf("%i\t",matrixd[i][j]);
        }
        printf("\n");
    }
    printf("Критерий MM: %i\nКритерий S: %i\nКритерий HW: %.2f\nc: %.2f\n", mm, s, hw, c);
    
    return 0;
}
