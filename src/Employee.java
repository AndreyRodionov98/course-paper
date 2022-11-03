import java.util.Objects;

public class Employee {
    private final int id ;
    private int departments;
    private String fullName;
    private int salary ;
    private static int counter=0;




    public Employee(String fullName,int salary,int departments){
        this.fullName=fullName;
        this.salary=salary;
        this.departments=departments;
        id=counter++;



    }
    public int getDepartments(){
        return departments;
    }

    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public int getSalary(){
    return salary;
    }

    public void setdepartments(int departments) {
        this.departments = departments;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Работник " + id +
                " отдел " + departments + '\'' +
                " Ф.И.О. " + fullName + '\'' +
                " зарплата " + salary ;
    }


    }



