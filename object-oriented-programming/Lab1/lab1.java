/*
Task_1:

Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. 
Размеры отрезка и параметры задаются в качестве параметров в консоли.
Результат представить в виде таблицы, первый столбец которой – значения аргумента, 
второй - соответствующие значения функции:
	F(x) = tg(2x) - 3
 */
package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 *
 * @author terehin.andrey
 */
public class Lab1 {

    public static void main(String[] args) throws IOException {
        float a, b, h;
        System.out.println("Enter a:");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        a = Float.parseFloat(in.readLine());
        
        System.out.println("Enter b:");
        b = Float.parseFloat(in.readLine());
  
        System.out.println("Enter h:");
        h = Float.parseFloat(in.readLine());
        
        if (a > b) {
            throw new IllegalArgumentException("'A must be < than B !");
        }
        if (h > b - a) {
            throw new IllegalArgumentException("H must be < than (B-A)!");
        }
        
        DecimalFormat df = new DecimalFormat("#.###");
        
        System.out.println("F(x) = tg(2x) - 3\n x   | F(x)\n=================");
        for (float i = a; i <= b; i += h)
        {
            float f = (float) (Math.tan(2*i) - 3);
            System.out.println(" " + df.format(i) + " | " + df.format(f));
        }
         
    }
    
}
