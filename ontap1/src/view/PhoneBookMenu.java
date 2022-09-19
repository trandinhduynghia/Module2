package view;

import controller.IPhoneBookManagement;
import controller.PhoneBookManagement;
import model.Person;
import validate.Validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookMenu {
    public static void main(String[] args) {
        PhoneBookMenu phoneBookMenu = new PhoneBookMenu();
        phoneBookMenu.run();
    }
    Scanner scanner = new Scanner(System.in);
    private static Scanner inputNumber = new Scanner(System.in);
    private static Scanner inputString = new Scanner(System.in);
    public void run() {
        int choice = -1;
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        do {
            menu();
                System.out.println("Nhập lựa chọn của bạn: ");
                choice = Validate.validateNumber();
            if (choice > 7 || choice <0) {
                System.err.println("Menu chỉ có từ 1 - 7!");
            }
            switch (choice) {
                case 1: {
                    phoneBookManagement.displayAll();
                    break;
                }
                case 2: {
                    phoneBookManagement.add();
                    break;
                }
                case 3: {
                    phoneBookManagement.update();
                    break;
                }
                case 4: {
                    phoneBookManagement.remove();
                    break;
                }
                case 5: {
                    doFindPhoneBook(phoneBookManagement);
                    break;
                }
                case 6: {
                        phoneBookManagement.readFiles();
                    break;
                }
                case 7: {
                    phoneBookManagement.writeToFiles();
                    break;
                }
            }
        } while (choice != 0);
    }
    private void menu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("1. Xem danh sách.");
        System.out.println("2. Thêm mới.");
        System.out.println("3. Cập nhật.");
        System.out.println("4. Xóa.");
        System.out.println("5. Tìm kiếm.");
        System.out.println("6. Đọc từ file.");
        System.out.println("7. Ghi vào file.");
        System.out.println("0. Thoát.");
    }

    private void doFindPhoneBook(PhoneBookManagement phoneBookManagement) {
        int choiceFind = -1;
        do {
            System.out.println("1. Tìm theo Số điện thoại.");
            System.out.println("2. Tìm theo tên.");
            System.out.println("0. Quay lại");
            System.out.println("Nhập lựa chọn của bạn: ");
            choiceFind = Validate.validateNumber();
            if (choiceFind > 2 || choiceFind < 0 ){
                System.err.println("MENU chỉ có 1 và 2!");
            }
            switch (choiceFind){
                case 1 :{
                    phoneBookManagement.findByPhoneNumber();
                    break;
                }
                case 2 :{
                    phoneBookManagement.findByName();
                    break;
                }
            }
        }while (choiceFind != 0);
    }
}
