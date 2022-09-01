package services;

import models.Customer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl {
    private List<Customer> customers = new LinkedList<>();

    public CustomerServiceImpl(){

    }

    public void disPlayAllCustomer(){
        for(int i = 0; i < customers.size(); i++){
            System.out.println(customers.get(i));
        }
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void updateCustomer(int id, Customer customer){
        customers.set(id, customer);
    }

    public boolean findID(int id){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }

}
