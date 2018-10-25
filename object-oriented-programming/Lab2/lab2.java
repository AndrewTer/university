/*
Task_2:

1)  Создать приложение с 2 классами - Book, Shoe  и  интерфейсом Product. 
    Интерфейс содержит метод whoAmI, который будет реализован в имплементирующих классах. 

2) Определить новый интерфейс Present, расширяющий интерфейс Product и содержащий  метод itCanBePresented(), 
    который может возвращать строку.

3) Объявить 2 новых класса (например Toy, Picture), реализующих  интерфейс Present.

4) В приложении создать массив объектов Product - (Book, Shoe, Toy, Picture), состоящий из количества элементов, 
    заданного параметром.

5) Найти в массиве те объекты, которые реализуют интерфейс Present и выполнить для них метод itCanBePresented().

Вывод должен содержать названия всех продуктов из массива, затем только тех продуктов, которые реализуют 
интерфейс Present.
*/

package lab2;

/**
 *
 * @author terehin.andrey
 */
 
public class Lab2 {
 public static void main(String[] args) {
        int count = 4;
        int temp = 0;
        Product[] products = new Product[count];

        for (int i = 0; i < count; i++) {
            switch(temp = i % 4) {
                case 0:
                    products[i] = new Book();
                    break;
                case 1:
                    products[i] = new Shoe();
                    break;
                case 2:
                    products[i] = new Toy();
                    break;
                case 3:
                    products[i] = new Picture();
                    break;
            }
        }

        System.out.println("Названия всех продуктов из массива:");
        
        for (int i = 0; i < count; i++) {
            products[i].whoAmI();
        }

        System.out.println("\nПродукты, которые реализуют интерфейс Present:");

        for (int i = 0; i < count; i++) {
            if (products[i] instanceof Present) {
                System.out.println(((Present) products[i]).it_can_be_presented());
            }
        }
    }
}
