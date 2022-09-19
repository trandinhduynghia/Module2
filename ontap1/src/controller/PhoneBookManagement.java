package controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import exception.UserException;
import model.Person;
import sort.NameComparator;
import validate.Validate;

import java.io.*;
import java.util.*;

public class PhoneBookManagement  {
    Scanner scanner = new Scanner(System.in);

    public List<Person> phoneBooks = new ArrayList<>();

    public PhoneBookManagement(){

    }

    private Person inputNewPhoneBook() {
        System.out.println("Họ và tên: ");
        String name = null;
        while (true){
            try {
                name = Validate.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Số điện thoại: ");
        String phoneNumber = null;
        while (true){
            try {
                phoneNumber = Validate.validatePhoneNumber();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhóm: ");
        String group = scanner.nextLine();
        System.out.println("Giới tính: ");
        String sex = null;
        while (true){
            try {
                sex = Validate.validateGender();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Email: ");
        String email = null;
        while (true){
            try {
                email = Validate.validateEmail();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Địa chỉ: ");
        String address = scanner.nextLine();
        return new Person(name, group, phoneNumber, sex, email, address);
    }

    public void add() {
        Person newPerson = inputNewPhoneBook();
        phoneBooks.add(newPerson);
        System.out.println("Thêm thành công!");
    }


    public void update() {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (true) {
            try {
                phoneNumber = Validate.validatePhoneNumber();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        int index = findPersonByPhoneNumber(phoneNumber);
        if (index == -1) {
            System.err.println("SĐT nhập vào không tồn tại!");
        } else {
            Person newPersonInfo = inputNewPhoneBook();
            phoneBooks.set(index, newPersonInfo);
            System.out.println("Cập nhật thành công!");
        }
    }

    public void remove() {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (true) {
            try {
                phoneNumber = Validate.validatePhoneNumber();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        int index = findPersonByPhoneNumber(phoneNumber);
        if (index == -1) {
            System.err.println("SĐT nhập vào không tồn tại!");
        } else {
            phoneBooks.remove(index);
            System.out.println("Xóa thành công!");
        }
    }


    public void displayAll() {
        for (Person phoneBook : phoneBooks){
            System.out.println(phoneBook.toString());
        }
    }


    public Person getByIndex(int index) {
        return phoneBooks.get(index);
    }


    public int getSize() {
        return phoneBooks.size();
    }


    public int findPersonByPhoneNumber(String phoneNumber) {
        int index = -1;
        for(int i = 0; i < phoneBooks.size(); i++){
            if(phoneBooks.get(i).getPhoneNumber().equals(phoneNumber))
                index = i;
        }
        return index;
    }


    public int findPersonByName(String name) {
        int index = -1;
        for(int i = 0; i < phoneBooks.size(); i++){
            if(phoneBooks.get(i).getName().equals(name))
                index = i;
        }
        return index;
    }

    public void findByPhoneNumber(){
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = null;
        while (true) {
            try {
                phoneNumber = Validate.validatePhoneNumber();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        int index = findPersonByPhoneNumber(phoneNumber);
        if (index == -1) {
            System.err.println("SĐT nhập vào không tồn tại!");
        } else {
            System.out.println(phoneBooks.get(index));
        }
    }

    public void findByName(){
        System.out.println("Nhập họ và tên: ");
        String name = null;
        while (true){
            try {
                name = Validate.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        int index = findPersonByName(name);
        if (index == -1) {
            System.err.println("Tên nhập vào không tồn tại!");
        } else {
            System.out.println(phoneBooks.get(index));
        }
    }


    public List<Person> readFiles()  {
        String DELIMITER = ",";
        String EMPTY = "";
        List<Person> phoneBooks = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("D:\\Module2\\ontap1\\src\\data\\phoneBooks.csv"))){
            String temp;
            while ((temp = reader.readLine()) != null){
                if(EMPTY.equals(temp.trim())){
                    continue;
                }
                String[] result = temp.split(DELIMITER);
                if(result.length != 6){
                    continue;
                }
                String name = result[0];
                String group = result[1];
                String phoneNumber = result[2];
                String sex = result[3];
                String email = result[4];
                String address = result[5];
                phoneBooks.add(new Person(name, group, phoneNumber, sex, email, address));
            }
            for(Person person : phoneBooks){
                System.out.println(person.toString());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return phoneBooks;
    }


    public void writeToFiles() {
        String DELIMITER = ",";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Module2\\ontap1\\src\\data\\phoneBooks.csv", true))){
            for(Person person: phoneBooks){
                writer.write(person.getName()+DELIMITER+person.getGroup()+DELIMITER+person.getPhoneNumber()+DELIMITER+person.getSex()+DELIMITER
                        +person.getEmail()+DELIMITER+person.getAddress());
                writer.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
