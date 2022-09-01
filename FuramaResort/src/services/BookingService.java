package services;
import models.Customer;

import java.util.Queue;

public interface BookingService extends ServiceInterface {
    void addBooking(Customer customer);
    Queue<Customer> getAllBooking();
}
