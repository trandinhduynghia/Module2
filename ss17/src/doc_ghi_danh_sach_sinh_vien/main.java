package doc_ghi_danh_sach_sinh_vien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "vu kieu anh", "ha noi"));
        students.add(new Student(2, "nguyen minh quan", "ha noi"));
        students.add(new Student(3, "dang huy hoa", "ha noi"));
        writeToFile("D:\\Module2\\ss17\\src\\doc_ghi_danh_sach_sinh_vien\\student",students);
        List<Student> studentDataFromFile = readDataFromFile("D:\\Module2\\ss17\\src\\doc_ghi_danh_sach_sinh_vien\\student");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }

    }
    public static void writeToFile(String path, List<Student> students){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
            System.out.println("Ghi danh sách sinh viên thành công!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }
}
