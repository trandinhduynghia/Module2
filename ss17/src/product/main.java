package product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        //products.add(new Product(0, "larue","larue",200000,"bia"));
        //productManager.addProduct(new Product(1, "cocacola","cocacola",150000,"nước ngọt"));
        //productManager.addProduct(new Product(2, "vinamilk","vinamilk",100000,"sữa"));
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
                    products.add(newProduct);
                    writeToFile("D:\\Module2\\ss17\\src\\product\\product", products);
                    break;
                case 2:
                    List<Product> productDataFromFile = readDataFromFile("D:\\Module2\\ss17\\src\\product\\product");
                    for (Product product : productDataFromFile) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    System.out.println("Nhập id sản phẩm: ");
                    int id = scanner.nextInt();
                    try {
                        System.out.println(products.get(id));
                    } catch (Exception e) {
                        System.out.println("Không tồn tại id");
                    }
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


    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
            System.out.println("Ghi danh sách sản phẩm thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> readDataFromFile(String path) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }
}
