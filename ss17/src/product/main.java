package product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager products = new ProductManager();
        int chose = -1;
        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm");
            System.out.println("Mời bạn nhập tùy chọn: ");
            chose = scanner.nextInt();
            if (chose > 3 || chose < 1) {
                System.out.println("Không có chức năng!");
            }
            switch (chose) {
                case 1:
                    Product newProduct = inputProductInfo();
                    products.addProduct(newProduct);
                    products.writeToFile();
                    break;
                case 2:
                    products.displayAllProduct();
                    break;
                case 3:
                    System.out.println(products.findProduct());
                    break;
            }
        }
    }

    public static Product inputProductInfo() {
        Scanner scanner = new Scanner(System.in);
        int id = getId();
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản xuất:");
        String manufacturer = scanner.nextLine();
        Double price = getPrice();
        System.out.println("Nhập mô tả:");
        String describe = scanner.nextLine();
        return new Product(id, name, manufacturer, price, describe);
    }

    public static int getId() {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        boolean isContinue = true;
        while (isContinue) {
            try {
                System.out.println("Nhập id:");
                id = Integer.parseInt(scanner.nextLine());
                if (id < 0 ) {
                    throw new ArithmeticException("Id không hợp lệ!");
                }
                isContinue = false;
            } catch (NumberFormatException e) {
                System.out.println("Id phải là số!");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }

    public static double getPrice() {
        Scanner scanner = new Scanner(System.in);
        double price = 0;
        boolean isContinue = true;
        while (isContinue) {
            try {
                System.out.println("Nhập giá:");
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0 ) {
                    throw new ArithmeticException("Giá không hợp lệ!");
                }
                isContinue = false;
            } catch (NumberFormatException e) {
                System.out.println("Giá phải là số!");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }
}
