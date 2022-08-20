package controller;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookManagement implements IPhoneBookManagement {
    private static final PhoneBookManagement INSTANCE = new PhoneBookManagement();

    public static PhoneBookManagement getInstance() {
        return INSTANCE;
    }
    public List<Person> getPhoneBooks() {
        return phoneBooks;
    }
        List<Person> phoneBooks = new ArrayList<>();
    public static final String fileNamePhoneBook = "src/com.codegym/data/contacts.csv";
    public PhoneBookManagement(){

    }

    public PhoneBookManagement(List<Person> phoneBooks){
        this.phoneBooks = phoneBooks;
    }

    @Override
    public void add(Person person) {
        phoneBooks.add(person);
    }

    @Override
    public void update(int index, Person person) {
        phoneBooks.set(index, person);
    }

    @Override
    public void remove(int index) {
        phoneBooks.remove(index);

    }

    @Override
    public void displayAll() {
        for (Person phoneBook : phoneBooks){
            System.out.println(phoneBook);
        }
    }

    @Override
    public Person getByIndex(int index) {
        return phoneBooks.get(index);
    }

    @Override
    public int getSize() {
        return phoneBooks.size();
    }

    @Override
    public int findPersonByPhoneNumber(String phoneNumber) {
        int index = -1;
        for(int i = 0; i < phoneBooks.size(); i++){
            if(phoneBooks.get(i).getPhoneNumber().equals(phoneNumber))
                index = i;
        }
        return index;
    }

    @Override
    public int findPersonByName(String name) {
        int index = -1;
        for(int i = 0; i < phoneBooks.size(); i++){
            if(phoneBooks.get(i).getName().equals(name))
                index = i;
        }
        return index;
    }

    @Override
    public List<String> readFiles()  {
        List<String> phoneBooks = new ArrayList<>();
        try{
            File file = new File("D:\\Module2\\ontap1\\src\\data\\phoneBooks.csv");

            if(!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                phoneBooks.add(line);
            }
            br.close();
            for(int i = 0; i < phoneBooks.size(); i++){
                System.out.println(phoneBooks.get(i));
            }
        }catch (Exception e){
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }
        return phoneBooks;
    }

    @Override
    public void writeToFiles(Person person1) {
        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("D:\\Module2\\ontap1\\src\\data\\phoneBooks.csv");
            for(Person person : persons){
                fileWriter.append(String.valueOf(person.getName()));
                fileWriter.append(",");
                fileWriter.append(person.getGroup());
                fileWriter.append(",");
                fileWriter.append(person.getPhoneNumber());
                fileWriter.append(",");
                fileWriter.append(person.getSex());
                fileWriter.append(",");
                fileWriter.append(person.getEmail());
                fileWriter.append(",");
                fileWriter.append(person.getAddress());
                fileWriter.append("\n");
            }
            System.out.println("ghi file thành công!");
        }catch (Exception e){
            System.out.println("File không tồn tại hoặc nội dung có lỗi!");
        }finally {
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch (IOException e){
                System.out.println("Lỗi khi ghi file!");
            }
        }

    }
}
