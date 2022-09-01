package services;

import models.Customer;

import java.util.Queue;

public interface ContractService extends ServiceInterface{
    void addContact(Customer customer);
    Queue<Customer> getAllContact();
}
