package services;

import models.*;

import java.util.*;
import java.util.concurrent.Callable;

public class BookingServiceImpl {
    Scanner scanner = new Scanner(System.in);
    private Set<Booking> bookings = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Service, Integer> facilityMap = new LinkedHashMap<>();

    static   {
        customerList.add(new Customer(1, "nghia", "02/08/2001", "nam", "123456789", "0765791651","nghia@gmail.com", "vip", "da nang"));

        facilityMap.put(new Villa("Vila 1",30,200,10,"vila","vila",30,3),0);
    }

    public BookingServiceImpl(){

    }

    public void displayAllBooking(){
        for(Booking booking : bookings){
            System.out.println(booking);
        }
    }

    public void addBooking(){
        int id = 0;
        if(!bookings.isEmpty()){
            id  = bookings.size();
        }
        Integer idCustomer = chooseCustomer();
        String nameService = chooseFacility();
        System.out.println("Nhập ngày bắt đầu: ");
        String startDay = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc: ");
        String finishDay = scanner.nextLine();
        System.out.println("Nhập loại dịch vụ: ");
        String typeService = scanner.nextLine();
        Booking booking = new Booking(id, startDay, finishDay, idCustomer, nameService, typeService);

        bookings.add(booking);
        System.out.println("Thêm booking thành công");

    }

    public Integer chooseCustomer(){
        for (Customer customer : customerList){
            System.out.println(customer.toString());
        }

        System.out.println("Nhập id khách hàng: ");
        boolean check = true;
        int id = Integer.parseInt(scanner.nextLine());

        while (check){
            for (Customer customer : customerList){
                if(id == customer.getId()){
                    check = false;
                    return id;
                }
            }
            if(check){
                System.out.println("Nhập id khách hàng: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public String chooseFacility(){
        for(Map.Entry<Service, Integer> entry : facilityMap.entrySet()){
            System.out.println(entry.getKey().toString());
        }
        boolean check = true;
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        while (check){
            for (Map.Entry<Service, Integer> entry : facilityMap.entrySet()){
                if(nameService.equals(entry.getKey().getNameService())){
                    check = false;
                    return entry.getKey().getNameService();
                }
            }
            if(check){
                System.out.println("Nhập tên dịch vụ: ");
                nameService = scanner.nextLine();
            }
        }
        return null;
    }

    public Set<Booking> sendBooking(){
        return bookings;
    }
}
