/*
Task_4:

Создать приложение, позволяющее читать *.properties-файлы.
Физическое чтение файла должно происходить только один раз.
Результаты чтения храните в коллекции типа Map.
После прочтения файла, пользователь может работать с ним через консоль, 
запрашивая значения по ключам, пока не нажата клавиша ESC.
Выход из программы происходит по нажатию Enter.
*/

package lab4;

import java.io.*;
import java.util.*;

/**
 *
 * @author terehin.andrey
 */

public class Lab4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String filename =  args[0] + ".properties"; 
            String value, key = null;
            Properties property = new Properties();
            Scanner in = new Scanner(System.in);

            try (FileInputStream fileinputs = new FileInputStream(filename)){
                property.load(fileinputs); 
                fileinputs.close();
            } catch (FileNotFoundException filenotfound) {
                System.err.println("Невозможно найти файл!");
                return;
            } catch (IOException ioe) {
                System.err.println("Невозможно открыть файл!");
                return;
            } catch (SecurityException securityex) {
                System.err.println("Файл недоступен!");
                return;
            }

            Map<String, String> map = new HashMap<>();

            property.stringPropertyNames().forEach((name) -> {
                map.put(name, property.getProperty(name));
            });

            while (true) {
                System.out.print("Введите ключ: ");
                key = in.nextLine();

                if (key.equals("")) {
                    System.out.print("Вы вышли из программы!\n");
                    return;
                }

                value = map.get(key);

                if (value == null) {
                    System.out.println("Невозможно найти ключ в файле!");
                } else switch(value) {
                    case "":
                        System.out.println("Значения нет!");
                        break;
                    default:
                        System.out.println("Значение: " + value);
                        break;
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrindexoutof) {
            System.err.println("Вы должны ввести параметр - имя файла!");
        }
    }
}
