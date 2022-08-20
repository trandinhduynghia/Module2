package product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void displayAllProduct(){
        for (Product product: products){
            System.out.println(product);
        }
    }

    public void findProduct(int id){
        products.get(id);
    }
}
