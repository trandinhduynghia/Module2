package array_list;

import java.util.*;

import static java.util.Comparator.*;


public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public ProductManager(){

    }

    public ProductManager(List<Product> products){
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product){
        products.add(product);
    }

    public void removeProduct(int id){
        products.remove(id);
    }

    public void updateProduct(int id, Product newProduct){
        products.set(id, newProduct);
    }

    public Product findProduct(String name){
        for(Product product : products){
            if(product.getName().equals(name)){
                return product;
            }
        }
return null;
    }

    public void displayAllProduct(){
        for(int i = 0; i < products.size(); i++){
            System.out.println(products.get(i));
        }
    }
    public boolean findID(int id){
        for(int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void sortProduct(){
        Collections.sort(products);
    }
}
