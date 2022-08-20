package product;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String manufacturer;
    private double price;
    private String describe;

    public Product(){

    }

    public Product(int id, String name, String manufacturer, double price, String describe){
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this. price = price;
        this. describe = describe;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String toString(){
        return "id: "+getId()+" name: "+getName()+" manufacturer:"+getManufacturer()+" price:"+getPrice()+" describe:"+getDescribe();

    }
}
