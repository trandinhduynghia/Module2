package array_list;

import java.io.Serializable;
import java.util.Comparator;

public class Product implements Comparable<Product>{
    private int id;
    private String name;
    public double price;

    public Product(){

    }

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "id: "+ getId()+" name: "+getName()+" price: "+getPrice();
    }

    public int compareTo(Product o){
        return (int) (this.price - o.price);
    }
}
