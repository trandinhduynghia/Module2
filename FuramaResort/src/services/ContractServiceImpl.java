package services;

import models.Booking;
import models.Contract;
import models.Customer;

import java.util.*;

public class ContractServiceImpl {
    Scanner scanner = new Scanner(System.in);
    private List<Contract> contractList = new ArrayList<>();

    public void createNewContract(){
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
        for(Booking booking : bookingSet){
            bookingQueue.add(booking);
        }
        while (!bookingQueue.isEmpty()){
            int idBooking = bookingQueue.peek().getIdBooking();
            int idCustomer = bookingQueue.poll().getIdCustomer();
            System.out.println("Nhập id hợp đồng: ");
            int idContract = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tiền đặt cọc: ");
            Double deposit = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập tiền thanh toán: ");
            Double payment = Double.parseDouble(scanner.nextLine());
            Contract contract = new Contract(idContract, idBooking, deposit, payment, idCustomer);
            contractList.add(contract);
            System.out.println("Đã tạo hợp đồng thành công!");
        }
    }

    public void displayListContract(){
        for(Contract contract : contractList){
            System.out.println(contract.toString());
        }
    }

    public void editContract(){

    }
}
