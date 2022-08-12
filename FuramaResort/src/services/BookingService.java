package services;
import models.Customer;

import java.util.Queue;

public interface BookingService {
    void addBooking(Customer customer);
    Queue<Customer> getAllBooking();
}
