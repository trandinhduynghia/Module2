package services;

import exception.UserException;
import validate1.Validator;
import models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl {
    Scanner scanner = new Scanner(System.in);
    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(){

    }

    public void displayAllEmployee(){
        employees = readFile();
        for(int i = 0; i < employees.size(); i++){
            System.out.println(employees.get(i));
        }
    }

    public Employee inputNewEmployeeInfo()  {
        System.out.println("Nhập id nhân viên:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên nhân viên: ");
        String name = null;
        while (true){
            try {
                name = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập ngày sinh: ");
        String birthday = null;
        while (true){
            try{
                birthday = Validator.validateBirthday();
                break;
            }catch (UserException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập giới tính: ");
        String gender = null;
        while (true){
            try{
                gender = Validator.validateGender();
                break;
            }catch (UserException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập số CMND: ");
        String idNumber = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (true){
            try{
                phoneNumber = Validator.validatePhoneNumber();
                break;
            }catch (UserException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập email: ");
        String email = null;
        while (true){
            try{
                email = Validator.validateEmail();
                break;
            }catch (UserException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập trình độ: ");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí: ");
        String location = scanner.nextLine();
        System.out.println("Nhập lương: ");
        Double wage = null;
        while (true){
            try{
                wage = Validator.validateNumber();
                break;
            }catch (UserException e){
                System.out.println(e.getMessage());
            }
        }
        return new Employee(id, name, birthday, gender, idNumber, phoneNumber, email, level, location, wage);
    }

    public void addEmployee(){
        employees = readFile();
        Employee newEmployee = inputNewEmployeeInfo();
        employees.add(newEmployee);
        System.out.println("Đã thêm nhân viên thành công!");
    }

    public void updateEmployee() {
        employees = readFile();
        System.out.println("Nhập id nhân viên: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean checkId = false ;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                checkId = true;
            }
        }
            if (checkId == true) {
                    Employee newEmployee = inputNewEmployeeInfo();
                    employees.set(id, newEmployee);
                    System.out.println("Đã cập nhật nhân viên thành công!");
                } else{
                    System.out.println("Mã nhân viên không tồn tại!");
                }
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
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module2\\FuramaResort\\src\\data\\employee.csv", false))){
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
