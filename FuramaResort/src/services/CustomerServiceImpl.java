package services;

import exception.UserException;
import models.Customer;
import models.Employee;
import validate1.Validator;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl {
    Scanner scanner = new Scanner(System.in);
    private List<Customer> customers = new LinkedList<>();

    public CustomerServiceImpl(){

    }

    public void disPlayAllCustomer(){
        customers = readFile();
        for(int i = 0; i < customers.size(); i++){
            System.out.println(customers.get(i));
        }
    }

    public Customer inputNewCustomerInfo() {
        System.out.println("Nhập id khách hàng:");
        int id = Integer.parseInt(scanner.nextLine());
        String name = null;
        System.out.println("Nhập tên khách hàng: ");
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
        System.out.println("Nhập loại khách hàng: ");
        String typeCustomer = scanner.nextLine();
        System.out.println("Nhập địa chị: ");
        String adress = scanner.nextLine();
        return new Customer(id, name, birthday, gender, idNumber, phoneNumber, email, typeCustomer, adress);
    }

    public void addCustomer(){
        customers = readFile();
        Customer newCustomer = inputNewCustomerInfo();
        customers.add(newCustomer);
        System.out.println("Đã thêm khách hàng thành công!");
    }

    public void updateCustomer() {
        customers = readFile();
        System.out.println("Nhập id khách hàng: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean checkId = false;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                checkId = true;
            }
            if (checkId == true) {
                Customer newCustomer = inputNewCustomerInfo();
                customers.set(id, newCustomer);
                System.out.println("Đã cập nhật khách hàng thành công!");
            } else {
                System.out.println("Mã khách hàng không tồn tại!");
            }
        }
    }

    public boolean findID(int id){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

    public void writeFile(){
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module2\\FuramaResort\\src\\data\\customer.csv", false))){
            for(Customer customer: customers){
                writer.write(customer.getId()+DELIMITER+customer.getName()+DELIMITER+customer.getBirthday()+DELIMITER+customer.getGender()+DELIMITER
                        +customer.getIdNumber()+DELIMITER+customer.getPhoneNumber()+DELIMITER+customer.getEmail()+DELIMITER+customer.getTypeCustomer()+DELIMITER+
                        customer.getAdress());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Customer> readFile(){
        String DELIMITER = ",";
        String EMPTY = "";
        List<Customer> customers = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module2\\FuramaResort\\src\\data\\customer.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 9){
                    continue;
                }
                int id = Integer.parseInt(result[0]);
                String name = result[1];
                String birthday = result[2];
                String gender = result[3];
                String idNumber = result[4];
                String phoneNumber = result[5];
                String email = result[6];
                String typeCustomer = result[7];
                String address = result[8];
                customers.add(new Customer(id, name, birthday, gender, idNumber, phoneNumber, email, typeCustomer, address));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return customers;
    }

}
