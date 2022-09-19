package controllers;

import models.*;
import services.*;
import validate.Validator;

import java.util.Scanner;
public class FuramaController{
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.run();
    }
    public void run(){
        int choose = -1;
        do{
            menu();
            System.out.println("Mời bạn nhập chức năng:");
            choose = scanner.nextInt();
            if (choose <= 0 || choose > 6) {
                System.out.println("Không có chức năng!");
            }
            switch (choose) {
                case 1:
                    employeeManager();
                    break;
                case 2:
                    costomerManager();
                    break;
                case 3:
                    facilityManagement();
                    break;
                case 4:
                    bookingManagement();
                    break;
                case 5:
                    promotionManagement();
                    break;
            }
        }while (choose != 6);
    }

    public void menu() {
        System.out.println("1. Employee Management");
        System.out.println("2. Customer Management");
        System.out.println("3. Facility Management");
        System.out.println("4. Booking Management");
        System.out.println("5. Promotion Management");
        System.out.println("6. Exit");
    }

    public void employeeManager() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        int choose1 = -1;
        do{
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employees");
            System.out.println("3. Edit employees");
            System.out.println("4. Return menu");
            System.out.println("Mời bạn nhập chức năng:");
            choose1 = scanner.nextInt();
            if (choose1 < 1 || choose1 > 4) {
                System.out.println("Không có chức năng!");
            }
            switch (choose1) {
                case 1: {
                    employeeService.displayAllEmployee();
                    break;
                }
                case 2: {
                    employeeService.addEmployee();
                    employeeService.writeFile();
                    break;
                }
                case 3: {
                    employeeService.updateEmployee();
                    employeeService.writeFile();
                    break;
                }
            }
        }while (choose1 != 4);
    }

    public void costomerManager() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        int choose2 = -1;
        do{
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Return main menu");
            System.out.println("Mời bạn nhập chức năng:");
            choose2 = scanner.nextInt();
            if (choose2 < 1 || choose2 > 4) {
                System.out.println("Không có chức năng!");
            }
            switch (choose2) {
                case 1:
                    customerService.disPlayAllCustomer();
                    break;
                case 2: {
                    customerService.addCustomer();
                    customerService.writeFile();
                    break;
                }
                case 3:
                    customerService.updateCustomer();
                    customerService.writeFile();
                    break;
            }
        }while (choose2 != 4);
    }

    public void facilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        int choose3 = -1;
        do{
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("Mời bạn nhập chức năng:");
            choose3 = scanner.nextInt();
            if (choose3 < 1 || choose3 > 4) {
                System.out.println("Không có chức năng!");
            }
            switch (choose3) {
                case 1:
                    facilityService.displayAllFacility();
                    break;
                case 2: {
                    int choose;
                    do {
                        System.out.println("1. Add new villa");
                        System.out.println("2. Add new house");
                        System.out.println("3. Add new room");
                        System.out.println("4. Back to menu");
                        System.out.println("Mời bạn nhập chức năng:");
                        choose = scanner.nextInt();
                        if (choose < 1 || choose > 4) {
                            System.out.println("Không có chức năng!");
                        }
                        switch (choose) {
                            case 1:
                                facilityService.addVilla();
                                break;
                            case 2:
                                facilityService.addHouse();
                                break;
                            case 3:
                                facilityService.addRoom();
                                break;
                        }
                        break;
                    }while (choose != 4) ;
                }
                case 3:
                    break;
            }
        }while (choose3 != 4);
    }

    public void bookingManagement() {
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contractService = new ContractServiceImpl();
        int choose4 = -1;
        do{
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new constracts");
            System.out.println("4. Display list constracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return main menu");
            choose4 = scanner.nextInt();
            if (choose4 < 1 || choose4 > 4) {
                System.out.println("Không có chức năng!");
            }
            switch (choose4) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    bookingService.displayAllBooking();
                    break;
                case 3:
                    contractService.createNewContract();
                    break;
                case 4:
                   contractService.displayListContract();
                    break;
                case 5:
                    break;
            }
        }while (choose4 != 6);
    }

    public void promotionManagement(){
        int choose5 = -1;
        do{
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            choose5 = scanner.nextInt();
        }while(choose5 != 3);
    }

}