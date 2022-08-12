package services;

import models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl {
    public  static  Scanner scanner = new Scanner(System.in);
    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(){

    }
    public EmployeeServiceImpl(List<Employee> employees){
        this.employees = employees;
    }
    public void displayAllEmployee(){
        for(int i = 0; i < employees.size(); i++){
            System.out.println(employees.get(i));
        }
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void updateEmployee(int id, Employee newEmployee){
        employees.set(id, newEmployee);

    }
    public boolean findID(int id){
        for(int i = 0; i < employees.size(); i++){
            if(employees.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Employee employee = new Employee(0,"nghia","2-8-2001","nam","201807035","0765791657","nghia@gmail.com","dai hoc","da nang", 5000000);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        employeeService.addEmployee(employee);
        employeeService.displayAllEmployee();
    }
}
