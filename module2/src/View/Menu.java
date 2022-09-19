package View;

import Controller.QuanLySoTietKiem;
import Validate.Validate;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
    public void run() {
        int choice = -1;
        QuanLySoTietKiem quanLySoTietKiem = new QuanLySoTietKiem();
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn: ");
            choice = Validate.validateNumber();
            if (choice > 4 || choice <0) {
                System.err.println("Menu chỉ có từ 1 - 4!");
            }
            switch (choice) {
                case 1: {
                    System.out.println("Nhập D để thêm STK dài hạn - Nhập N để thêm STK ngắn hạn");
                    String a = scanner.nextLine();
                    switch (a){
                        case "D":
                            quanLySoTietKiem.themSTKDaiHan();

                            break;
                        case "N": {
                            System.out.println("Nhập V để thêm hợp STK ngắn hạn vô thời hạn - Nhập C để thêm STK ngắn hạn có thời hạn");
                            String b = scanner.nextLine();
                            switch (b){
                                case "V":
                                    quanLySoTietKiem.themSTKNganHanVoThoiHan();

                                    break;
                                case "C":
                                    quanLySoTietKiem.themSTKNganHan();

                                    break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập D để xóa STK dài hạn - Nhập N để xóa STK ngắn hạn");
                    String a = scanner.nextLine();
                    switch (a){
                        case "D":
                            quanLySoTietKiem.xoaSTKDaiHan();

                            break;
                        case "N":
                            quanLySoTietKiem.xoaSTKNganHan();

                            break;
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhập D để xem STK dài hạn - Nhập N để xem STK ngắn hạn");
                    String a = scanner.nextLine();
                    switch (a){
                        case "D":
                            quanLySoTietKiem.hienThiSTKDaiHan();
                            break;
                        case "N":
                            //quanLySoTietKiem.hienThiSTKNganHan();
                            quanLySoTietKiem.readFiles1();
                            break;
                    }
                    break;
                }
            }
        } while (choice != 4);
    }
    private void menu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SỔ TIẾT KIỆM----");
        System.out.println("1. Thêm mới.");
        System.out.println("2. Xóa.");
        System.out.println("3. Xem danh sách.");
        System.out.println("4. Thoát.");
    }
}
