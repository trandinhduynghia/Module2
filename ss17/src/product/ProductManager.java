package product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void displayAllProduct(){
        products = readDataFromFile();
        for(Product product: products){
            System.out.println(product.toString());
        }
    }

    public Product findProduct(){
        products = readDataFromFile();
        System.out.println("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        while (check){
            for(Product product: products){
                if(id == product.getId()){
                    check = false;
                    return product;
                }
            }
            if(check){
                System.out.println("Nhập id sản phẩm: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }
    public  void writeToFile() {
        try {
            FileOutputStream fos = new FileOutputStream("D:\\Module2\\ss17\\src\\product\\product");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
            System.out.println("Ghi danh sách sản phẩm thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  List<Product> readDataFromFile() {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("D:\\Module2\\ss17\\src\\product\\product");
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
