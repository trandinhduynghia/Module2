package services;

import models.Customer;

import java.util.Queue;

public interface ContactService {
    void addContact(Customer customer);
    Queue<Customer> getAllContact();
}
