package services;

import models.Booking;
import models.Contract;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class BookingServiceImpl {
    private SortedSet<Booking> bookings = new TreeSet<>();
    private Queue<Contract> contracts = new LinkedList<>();

    public BookingServiceImpl(){

    }

    public BookingServiceImpl(SortedSet<Booking> bookings, Queue<Contract> contracts){
        this.bookings = bookings;
        this.contracts = contracts;
    }

    public void displayAllBooking(){
        for(Object object : bookings){
            System.out.println(object);
        }
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public void displayAllContract(){
        for(Object object : contracts){
            System.out.println(object);
        }
    }

    public void addContract(Contract contract){
        contracts.add(contract);

    }

    public void updateContract(Contract contract){
    }
}
