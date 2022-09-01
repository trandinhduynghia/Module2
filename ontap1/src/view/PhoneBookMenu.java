package view;

import controller.IPhoneBookManagement;
import controller.PhoneBookManagement;
import model.Person;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBookMenu {
    public static void main(String[] args) {
        PhoneBookMenu phoneBookMenu = new PhoneBookMenu();
        phoneBookMenu.run();
    }
    private static Scanner inputNumber = new Scanner(System.in);
    private static Scanner inputString = new Scanner(System.in);
    public void run() {
        int choice = -1;
        PhoneBookManagement phoneBookManagement = new PhoneBookManagement();
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = inputNumber.nextInt();
            if (choice > 7) {
                System.err.println("Menu chỉ có từ 1 - 7!");
            }
            switch (choice) {
                case 1: {
                    doDisplayAllPhoneBook(phoneBookManagement);
                    break;
                }
                case 2: {
                    doAddNewPhoneBook(phoneBookManagement);
                    break;
                }
                case 3: {
                    doUpdatePhoneBook(phoneBookManagement);
                    break;
                }
                case 4: {
                    doRemovePhoneBook(phoneBookManagement);
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
                    Person newPersonInfo = inputNewPhoneBookInfo();
                    phoneBookManagement.writeToFiles(newPersonInfo);
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
    private void doDisplayAllPhoneBook(IPhoneBookManagement phoneBookManagement) {
        System.out.println("----Xem danh sách----");
        int size = phoneBookManagement.getSize();
        if (size == 0) {
            System.err.println("Danh bạ rỗng!");
        } else {
            phoneBookManagement.displayAll();
        }
    }
    private boolean checkRegex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
    private String inputPhoneNumber() {
        while (true) {
            System.out.println("Nhập số điện thoại theo dạng (84)-(0xxxxxxxxx)");
            String phoneNumber = inputString.nextLine();
            final String REGEX_PHONENUMBER = "^[(][0-9][1-9][)][-][(][0][0-9]{9}[)]$";
            boolean isCheckPhoneNumber = checkRegex(REGEX_PHONENUMBER, phoneNumber);
            if (isCheckPhoneNumber) {
                System.out.println("Số điện thoại hợp lệ!");
                return phoneNumber;
            } else {
                System.err.println("Nhập số điện thoại theo dạng (84)-(0xxxxxxxxx)");
            }
        }
    }
    private String inputEmail() {
        while (true) {
            System.out.println("Nhập email theo dạng(thangnguyen@gmail.com)");
            String email = inputString.nextLine();
            final String REGEX_EMAIL = "^\\w+@\\w+(\\.\\w+){1,2}$";
            boolean isCheckEmail = checkRegex(REGEX_EMAIL, email);
            if (isCheckEmail) {
                System.out.println("Email hợp lệ!");
                return email;
            } else {
                System.err.println("Nhập email theo dạng(thangnguyen@gmail.com)");
            }
        }
    }
    public  String inputName() {
        while (true) {
            String name = inputString.nextLine();
            final String REGEX_NAME = "^((\\p{Lu})(\\p{Ll}*))( (\\p{Lu})(\\p{Ll}*))*$";
            boolean isCheckName = checkRegex(REGEX_NAME, name);
            if (isCheckName) {
                return name;
            } else {
                System.out.println("Nhập tên theo dang Abc Abc");
            }
        }
    }
    private Person inputNewPhoneBookInfo() {
        System.out.println("Nhập thôn tin danh bạ");
        System.out.println("Họ và tên: ");
        String name = inputName();
        System.out.println("Số điện thoại: ");
        String phoneNumber = inputPhoneNumber();
        System.out.println("Nhóm: ");
        String group = inputString.nextLine();
        System.out.println("Giới tính: ");
        String sex = inputString.nextLine();
        System.out.println("Email: ");
        String email = inputEmail();
        System.out.println("Địa chỉ: ");
        String address = inputString.nextLine();
        return new Person(name, group, phoneNumber, sex, email, address);
    }
    private void doAddNewPhoneBook(IPhoneBookManagement phoneBookManagement) {
        Person newPersonInfo = inputNewPhoneBookInfo();
        phoneBookManagement.add(newPersonInfo);
        System.out.println("Thêm thành công!");
    }
    private void doUpdatePhoneBook(IPhoneBookManagement phoneBookManagement) {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = inputString.nextLine();
        int index = phoneBookManagement.findPersonByPhoneNumber(phoneNumber);
        if (index == -1) {
            System.err.println("SĐT nhập vào không đúng");
        } else {
            Person newPersonInfo = inputNewPhoneBookInfo();
            phoneBookManagement.update(index, newPersonInfo);
            System.out.println("Cập nhật thành công!");
        }
    }
    private void doRemovePhoneBook(IPhoneBookManagement phoneBookManagement) {
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = inputString.nextLine();
        int index = phoneBookManagement.findPersonByPhoneNumber(phoneNumber);
        if (index == -1) {
            System.err.println("SĐT nhập vào không đúng");
        } else {
            phoneBookManagement.remove(index);
            System.out.println("Xóa thành công!");
        }
    }
    private void doFindPhoneBook(IPhoneBookManagement phoneBookManagement) {
        int choiceFind = -1;
        do {
            System.out.println("1. Tìm theo Số điện thoại.");
            System.out.println("2. Tìm theo tên.");
            System.out.println("0. Quay lại");
            System.out.println("Nhập lựa chọn của bạn: ");
            choiceFind = inputNumber.nextInt();
            if (choiceFind > 2 ){
                System.err.println("MENU chỉ có 1 và 2!");
            }
            switch (choiceFind){
                case 1 :{
                    System.out.println("Nhập số điện thoại: ");
                    String phoneNumber = inputString.nextLine();
                    int index = phoneBookManagement.findPersonByPhoneNumber(phoneNumber);
                    if (index == -1) {
                        System.err.println("SĐT nhập vào không đúng");
                    } else {
                        System.out.println(phoneBookManagement.getByIndex(index));
                    }
                    break;
                }
                case 2 :{
                    System.out.println("Nhập họ và tên: ");
                    String name = inputString.nextLine();
                    int index = phoneBookManagement.findPersonByName(name);
                    if (index == -1) {
                        System.err.println("Tên nhập vào không tồn tại!");
                    } else {
                        System.out.println(phoneBookManagement.getByIndex(index));
                    }
                    break;
                }
            }
            break;
        }while (choiceFind != 0);
    }
}
