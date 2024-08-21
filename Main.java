
import java.util.ArrayList;

abstract class Employee{
    private String Name;
    private int ID;

    public Employee(String Name,int ID){
        this.Name = Name;
        this.ID = ID;

    }
    public String getName(){
        return Name;
    }
    public int getID(){
        return ID;
    }
    public abstract double calculateSalary();
    @Override
    public String toString(){
        return "Employee[name=" + Name +", ID="+ID+", salary="+ calculateSalary()+"]";

    }




}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String Name, int ID,double monthlySalary){
        super(Name, ID);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;

    }


}
class PartTimeEmployee extends Employee{
    private int HoursWorked;
    private int HourlyRate;
    public PartTimeEmployee(String Name, int ID,int HoursWorked,int HourlyRate){
        super (Name ,ID );
        this.HourlyRate = HourlyRate;
        this.HoursWorked = HoursWorked;
    }
    @Override
    public double calculateSalary(){
        return HoursWorked*HourlyRate;

    }

}
class payRollSystem{
    private ArrayList<Employee> employeeList;
    public payRollSystem(){
        employeeList = new ArrayList<>();

    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int ID){
        Employee employeeToRemove = null;
        for(Employee employee : employeeList){
            if(employee.getID() == ID){
                employeeToRemove = employee;
                break;
            }
        if(employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }

        }
    }
    public void displayEmployees(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }


}






public class Main {
    private static final String Vishal = null;

    public static void main(String[]args){

        payRollSystem payrollSystem =new payRollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vishal", 1, 70000);
        PartTimeEmployee emp2 = new PartTimeEmployee( "Naman", 2, 40, 1200);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();
        System.out.println("Removing Employees:");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining Employees Details:");
        payrollSystem.displayEmployees();
    }
}