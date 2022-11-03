import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 154330, 1);
        employees[1] = new Employee("Степанов Иван Степанович", 140000, 2);
        employees[2] = new Employee("Федоров Иван Иванович", 160000, 3);
        employees[3] = new Employee("Шамин Степан Федорович", 100221, 4);
        employees[4] = new Employee("Иванов Степан Ильич", 90000, 5);
        employees[5] = new Employee("Семин Илья Иванович", 149221, 1);
        employees[6] = new Employee("Шамин Сергей Иванович", 142221, 4);
        employees[7] = new Employee("Сергеев Иван Аркадьевич", 143221, 4);
        employees[8] = new Employee("Иванов Сергей Павлович", 123421, 2);
        employees[9] = new Employee("Малых Петр Иванович", 134221, 3);
        printArray(employees);
        System.out.println("Сумма затрат на зарплаты в месяц " + colculateSumSalary(employees));
        System.out.println("Минимальная зарплата " + minSalary(employees));
        System.out.println(" Максимальная зарплата " + maxSalary(employees));
        System.out.println(" Среднее значение зарплат" + avargeColculateSumSalary(employees));
        System.out.println("------------------------------");
        printFullNames(employees);
    }

    public static void printArray(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static float colculateSumSalary(Employee[] employees) {
        float sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getSalary();

            }
        }
        return sum;
    }

    public static Employee minSalary(Employee[] employees) {
        Employee minSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() <= minSalary.getSalary() && employees[i] != null) {

                minSalary = employees[i];
            }

        }
        return minSalary;
    }

    public static Employee maxSalary(Employee[] employees) {
        Employee maxSalary = employees[0];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() >= maxSalary.getSalary() && employees[i] != null) {
                maxSalary = employees[i];
            }

        }
        return maxSalary;
    }

    public static float avargeColculateSumSalary(Employee[] employees) {
        float sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                sum = sum + employees[i].getSalary() / 10;

            }
        }
        return sum;
    }

    public static void printFullNames (Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }
}





















