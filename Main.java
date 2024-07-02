package employee.payroll.system;

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    Employee(String name,int id){
    this.name=name;
    this.id=id;
    }
    public String getName(){
    return name;
    }
    public int getId(){
    return id;
    }
    public abstract double calculateSalary();
    
    @Override
    public String toString(){
    return "Employee [name="+name+",id="+id+",salary="+calculateSalary()+"]";
    }
}

class FullTimeEmp extends Employee{
private double monthlySalary;

public FullTimeEmp(String name,int id,double monthlySalary){
    super(name,id);
    this.monthlySalary=monthlySalary;
}
@Override
public double calculateSalary(){
return monthlySalary;
}
}

class PartTimeEmp extends Employee{
private int hoursWorked;
private double hourlyRate;
public PartTimeEmp(String name,int id,int hoursWorked,double houlyRate){
super(name,id);
this.hoursWorked=hoursWorked;
this.hourlyRate=hourlyRate;
}
public double calculateSalary(){
return hoursWorked*hourlyRate;
}
}
class PayrollSystem{
private ArrayList<Employee> employeeList;

public PayrollSystem(){
employeeList=new ArrayList();
}
public void addEmployee(Employee employee){
    employeeList.add(employee);
}
public void removeEmployee(int id){
Employee employeeToRemove=null;
for(Employee employee:employeeList){
if(employee.getId()==id){
employeeToRemove=employee;
break;
}
}
if(employeeToRemove!=null){
employeeList.remove( employeeToRemove);}
}
public void displayEmployees(){
for(Employee employee:employeeList){
System.out.println(employee);
}

}
}

public class Main {
    public static void main(String args[]){
    PayrollSystem prs=new PayrollSystem();
    
   FullTimeEmp emp1=new FullTimeEmp("chhaya",1,70000.0);
   PartTimeEmp emp2=new PartTimeEmp("suraj",2,30,100.0);
   
    prs.addEmployee(emp1);
    prs.addEmployee(emp2);
    
    System.out.println("Initial Employee Details: ");
    prs.displayEmployees();
    
    System.out.println("Removing Employees");
    prs.removeEmployee(2);
    
    System.out.println("Remaining Employee Details");
    prs.displayEmployees();
    }
}
