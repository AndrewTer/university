/*
Task_3:

Создать приложение, позволяющее читать значение по ключу из *.properties-файлов.
В качестве входных параметров (в консоли) задаются: имя файла и ключ, для которого нужно получить значение.
Обработать все возможные исключительные ситуации.
*/

package lab3;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author terehin.andrey
 */

public class Lab3 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try {
            String filename = args[0];
            String key = args[1];
            String value;
            Properties property = new Properties();

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

            value = property.getProperty(key);
            System.out.println("Ключ: " + key);

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
            
        } catch (ArrayIndexOutOfBoundsException arrindexoutof) {
            System.err.println("Вы должны ввести два параметра - имя файла и ключ!");
        }
    }
    
}
