import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Иванов Иван Иванович", 54330.15, 1);
        employees[1] = new Employee("Степанов Иван Степанович", 40000.5, 2);
        employees[2] = new Employee("Федоров Иван Иванович", 60000.25, 3);
        employees[3] = new Employee("Шамин Степан Федорович", 70221.21, 4);
        employees[4] = new Employee("Иванов Степан Ильич", 90000.34, 5);
        employees[5] = new Employee("Семин Илья Иванович", 49221.43, 1);
        employees[6] = new Employee("Шамин Сергей Иванович", 42221.76, 4);
        employees[7] = new Employee("Сергеев Иван Аркадьевич", 43221.32, 4);
        employees[8] = new Employee("Иванов Сергей Павлович", 23421.32, 2);
        employees[9] = new Employee("Малых Петр Иванович", 34221.54, 3);
        //Базовый уровень

        printArray(employees);
        System.out.println("Сумма затрат на зарплаты в месяц " + colculateSumSalary(employees));
        System.out.println("Минимальная зарплата " + minSalary(employees));
        System.out.println(" Максимальная зарплата " + maxSalary(employees));
        System.out.println(" Среднее значение зарплат" + avargeColculateSumSalary(employees));
        printFullNames(employees);
        System.out.println("==============================");
        //Повышенная сложность

        indexSalaries(10, employees);
        printArray(employees);
        int neededDepartment = 1;
        Employee[] neededDepartmentArray = filterByDepartments(neededDepartment, employees);
        System.out.println("Сотрудник с минимальной зарплатой в отделе " + neededDepartment + ":" + minSalary(neededDepartmentArray));
        System.out.println("Сотрудник с максимальной зарплатой в отделе " + neededDepartment + ":" + maxSalary(neededDepartmentArray));
        System.out.println(" Сумма затрат на зарплаты по отделу " + neededDepartment + ":" + colculateSumSalary(neededDepartmentArray));
        System.out.println(" Среднее значение зарплат по отделу " + neededDepartment + ":" + avargeColculateSumSalary(neededDepartmentArray));
        indexSalariesInDepartment(10, employees, neededDepartment);
        neededDepartmentArray = filterByDepartments(neededDepartment, employees);
        System.out.println("Сотрудники отдела " + neededDepartment + " после индексации ");
        printArray(neededDepartment, employees);
        System.out.println("Сотрудники с зарплатой меньшей чем 40000 :");
        printEmployeeWithSalaryLawThan(40000, employees);
        System.out.println("Сотрудники с зарплатой ,большей чем 40000 :");
        printEmployeeWithSalaryMoreThan(40000,employees);


    }

    public static void printArray(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].toString());
            }
        }
    }

    public static void printArray(int departments, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartments() == departments) {
                System.out.println("сотрудник " + employees[i].getId() +
                        " " + employees[i].getFullName() + '\'' +
                        "" + employees[i].getSalary());
            }


        }
    }

    public static double colculateSumSalary(Employee[] employees) {
        double sum = 0;
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

    public static double avargeColculateSumSalary(Employee[] empls) {
        double sum = 0;
        for (int i = 0; i < empls.length; i++) {
            if (empls[i] != null) {
                sum++;

            }
        }
        return colculateSumSalary(empls) / sum;
    }

    public static void printFullNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                System.out.println(employees[i].getFullName());
            }
        }
    }

    public static double indexSalaries(double index, Employee[] employees) {
        System.out.println("проиндексировали зарплату на " + index + " %");
        index = index / 100 + 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employees[i].setSalary(index * employees[i].getSalary());
            }
        }
        return index;
    }

    public static void indexSalariesInDepartment(double index, Employee[] employees, int departments) {
        index = index / 100 + 1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartments() == departments) {
                employees[i].setSalary(index * employees[i].getSalary());
            }
        }
    }

    public static Employee[] filterByDepartments(int departments, Employee[] employees) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartments() == departments) {
                counter++;
            }
        }
        Employee[] result = new Employee[counter];
        int index = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartments() == departments) {
                result[index] = employees[i];
                index++;
            }
        }
        return result;
    }

    public static void printEmployeeWithSalaryLawThan(double salary, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                System.out.println(employees[i].toStringWithOutDepartment());
            }

        }

    }

    public static void printEmployeeWithSalaryMoreThan(double salary, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() >= salary) {
                System.out.println(employees[i].toStringWithOutDepartment());
            }
        }
    }
}






















