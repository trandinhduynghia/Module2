package services;

import models.Employee;

import java.io.*;
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
        employees = readFile();
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
    public void writeFile(){
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module2\\FuramaResort\\src\\data\\employee.csv", true))){
            for(Employee employee: employees){
                writer.write(employee.getId()+DELIMITER+employee.getName()+DELIMITER+employee.getBirthday()+DELIMITER+employee.getGender()+DELIMITER
                +employee.getIdNumber()+DELIMITER+employee.getPhoneNumber()+DELIMITER+employee.getEmail()+DELIMITER+employee.getLevel()+DELIMITER+
                        employee.getLocation()+DELIMITER+employee.getWage());
                writer.newLine();
            }
            //System.out.println("Ghi file thành công!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<Employee> readFile(){
        String DELIMITER = ",";
        String EMPTY = "";
        List<Employee> employees = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module2\\FuramaResort\\src\\data\\employee.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 10){
                    continue;
                }
                int id = Integer.parseInt(result[0]);
                String name = result[1];
                String birthday = result[2];
                String gender = result[3];
                String idNumber = result[4];
                String phoneNumber = result[5];
                String email = result[6];
                String level = result[7];
                String location = result[8];
                double wage = Double.parseDouble(result[9]);
                employees.add(new Employee(id, name, birthday, gender, idNumber, phoneNumber, email, level, location, wage));
            }
            //for(Employee employee : employees){
                //System.out.println(employee);
            //}
        }catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }
}
