package array_list;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Product product = new Product(0, "bia", 50000);
        Product product1 = new Product(1, "gao", 20000);
        Product product2 = new Product(2, "nuoc ngot", 10000);
        productManager.addProducts(product);
        productManager.addProducts(product1);
        productManager.addProducts(product2);
        int choice = -1;
        while (true){
            menu();
            System.out.println("Nhập vào lựa chọn của bạn: ");
            choice = scanner.nextInt();
            if(choice == 0){
                break;
            }
            if(choice > 6 || choice < 0){
                System.out.println("Lựa chọn của bạn không phù hợp!");
            }
            switch (choice){
                case 1: {
                    System.out.println("Hiển thị toàn bộ danh sách");
                    productManager.displayAllProduct();
                    break;
                }
                case 2: {
                    System.out.println("Thêm sản phẩm");
                    Product newProduct = inputNewProductInfo();
                    productManager.addProducts(newProduct);
                    System.out.println("Đã thêm sản phẩm thành công");
                    break;
                }
                case 3: {
                    System.out.println("Cập nhật sản phẩm theo ID");
                    System.out.println("Nhập ID sản phẩm: ");
                    int id = scanner.nextInt();
                    if (productManager.findID(id)) {
                        Product newProduct = inputNewProductInfo();
                        productManager.updateProduct(id, newProduct);
                        System.out.println("Đã cập nhật sản phẩm thành công!");
                    } else {
                        System.out.println("Mã sản phẩm không tồn tại!");
                    }
                    break;
                }
                case 4: {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Xóa sản phẩm theo ID");
                    System.out.println("Nhập ID sản phẩm: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (productManager.findID(id)) {
                        productManager.removeProduct(id);
                        System.out.println("Đã xóa thành công!");
                    } else {
                        System.out.println("Mã sản phẩm không tồn tại!");
                    }
                    break;
                }
                case 5: {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Tìm sản phẩm theo tên");
                    System.out.println("Nhập tên sản phẩm: ");
                    String name = scanner.nextLine();
                    System.out.println(productManager.findProduct(name));
                    break;
                }
                case 6: {
                    System.out.println("Sắp xếp sản phẩm theo giá tăng dần");
                    productManager.sortProduct();
                    productManager.displayAllProduct();
                    break;
                }
            }
        }
    }
    public static void menu(){
        System.out.println("MENU QUẢN LÝ SẢN PHẨM");
        System.out.println("1. Hiển toàn bộ danh sách");
        System.out.println("2. Thêm sản phẩm ");
        System.out.println("3. Cập nhật sản phẩm theo ID");
        System.out.println("4. Xóa sản phẩm theo ID");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
        System.out.println("0. Thoát");
    }
    public static Product inputNewProductInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm");
        System.out.println("Nhập id sản phẩm:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        return new Product(id, name, price);
    }
}
