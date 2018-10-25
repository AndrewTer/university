/*	
Task_5:

Создать приложение с 3 потоками для следующей задачи: 
    3 работника выполняют следующую работу: 
        1-ый копает яму, 
        2-ой сажает дерево,  
        3-ий подвязывает саженец к кольям. 
    Работа идет строго по очереди. Число саженцев задается параметром.  
    Выводить на дисплей номер работника и номер саженца. 
 */
package lab5;

/**
 *
 * @author terehin.andrey
 */
public class Lab5 implements Runnable{
    static Work work;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number_of_employees;
        Runnable employees;
        Thread firstemployee, secondemployee, thirdemployee;
        
        number_of_employees = 3;//Integer.parseInt(args[0]);
        work = new Work(number_of_employees);
        employees = new Lab5();
        
        firstemployee = new Thread(employees);
        secondemployee = new Thread(employees);
        thirdemployee = new Thread(employees);

        firstemployee.setName("firstemployee");
        secondemployee.setName("secondemployee");
        thirdemployee.setName("thirdemployee");

        firstemployee.start();
        secondemployee.start();
        thirdemployee.start();
    }

    @Override
    public void run() {
        String employee_name = Thread.currentThread().getName();

        while (true) { 
            synchronized(this) {
                if (work.getCurrent() > work.getCount()) {
                        return;
                }

                if (employee_name.equals("firstemployee") && (work.getemployee() == 1)) {
                    System.out.println(work.getemployee() + " " + work.getCurrent());
                    work.setemployee(2);
                } else if (employee_name.equals("secondemployee") && (work.getemployee() == 2)) {
                    System.out.println(work.getemployee() + " " + work.getCurrent());
                    work.setemployee(3);
                } else if (employee_name.equals("thirdemployee") && (work.getemployee() == 3)) {
                    System.out.println(work.getemployee() + " " + work.getCurrent() + "\n---");
                    work.setemployee(1);
                    work.setCurrent(work.getCurrent() + 1);                    
                }
            }     
        }
    }
}
