package controllers;

import models.*;
import services.*;
import exception.Exception;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuramaController extends Exception{
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

    public Employee inputNewEmployeeInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập id nhân viên:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên nhân viên: ");
        String name = inputName();
        System.out.println("Nhập ngày sinh: ");
        String birthday = inputBirthday();
        System.out.println("Nhập giới tính: ");
        String gender = inputGender();
        System.out.println("Nhập số CMND: ");
        String idNumber = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = inputPhoneNumber();
        System.out.println("Nhập email: ");
        String email = inputEmail();
        System.out.println("Nhập trình độ: ");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí: ");
        String location = scanner.nextLine();
        System.out.println("Nhập lương: ");
        Double wage = inputRentalCots();
        return new Employee(id, name, birthday, gender, idNumber, phoneNumber, email, level, location, wage);
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
                    Employee newEmployee = inputNewEmployeeInfo();
                    employeeService.addEmployee(newEmployee);
                    employeeService.writeFile();
                    System.out.println("Đã thêm nhân viên thành công!");
                    break;
                }
                case 3: {
                    System.out.println("Nhập id nhân viên: ");
                    int id = scanner.nextInt();
                    if (employeeService.findID(id)) {
                        Employee newEmployee = inputNewEmployeeInfo();
                        employeeService.updateEmployee(id, newEmployee);
                        System.out.println("Đã cập nhật nhân viên thành công!");
                    } else {
                        System.out.println("Mã nhân viên không tồn tại!");
                    }
                    break;
                }
            }
        }while (choose1 != 4);
    }

    public Customer inputNewCustomerInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập id khách hàng:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên khách hàng: ");
        String name = inputName();
        System.out.println("Nhập ngày sinh: ");
        String birthday = inputBirthday();
        System.out.println("Nhập giới tính: ");
        String gender = inputGender();
        System.out.println("Nhập số CMND: ");
        String idNumber = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = inputPhoneNumber();
        System.out.println("Nhập email: ");
        String email = inputEmail();
        System.out.println("Nhập loại khách hàng: ");
        String typeCustomer = scanner.nextLine();
        System.out.println("Nhập địa chị: ");
        String adress = scanner.nextLine();
        return new Customer(id, name, birthday, gender, idNumber, phoneNumber, email, typeCustomer, adress);
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
                    Customer newCustomer = inputNewCustomerInfo();
                    customerService.addCustomer(newCustomer);
                    System.out.println("Đã thêm nhân viên thành công!");
                    break;
                }
                case 3:
                    System.out.println("Nhập id khách hàng: ");
                    int id = scanner.nextInt();
                    if (customerService.findID(id)) {
                        Customer newCustomer = inputNewCustomerInfo();
                        customerService.updateCustomer(id, newCustomer);
                        System.out.println("Đã cập nhật khách hàng thành công!");
                    } else {
                        System.out.println("Mã khách hàng không tồn tại!");
                    }
                    break;
            }
        }while (choose2 != 4);
    }

    public Villa inputNewVillaInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = inputName();
        System.out.println("Nhập diện tích: ");
        double areaUse = inputArea();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = inputRentalCots();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = inputMaxNumberOfPeople();
        System.out.println("Nhập loại thuê: ");
        String typeRent = inputName();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = inputName();
        System.out.println("Nhập diện tích hồ bơi: ");
        Double areaPool = inputArea();
        System.out.println("Nhập số lầu: ");
        int numberOfFloors = inputNumberOfFloors();
        return new Villa(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, roomStandard, areaPool, numberOfFloors);
    }

    public House inputNewHouseInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = inputName();
        System.out.println("Nhập diện tích: ");
        double areaUse = inputArea();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = inputRentalCots();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = inputMaxNumberOfPeople();
        System.out.println("Nhập loại thuê: ");
        String typeRent = inputName();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = inputName();
        System.out.println("Nhập số lầu: ");
        int numberOfFloors = inputNumberOfFloors();
        return new House(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, roomStandard, numberOfFloors);
    }

    public Room inputNewRoomInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = inputName();
        System.out.println("Nhập diện tích: ");
        double areaUse = inputArea();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = inputRentalCots();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = inputMaxNumberOfPeople();
        System.out.println("Nhập loại thuê: ");
        String typeRent = inputName();
        System.out.println("Nhập dịch vụ miễn phí: ");
        String freeService = scanner.nextLine();
        return new Room(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, freeService);
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
                                Villa newVilla = inputNewVillaInfo();
                                System.out.println("Nhập vào số lần đã sử dụng: ");
                                int use = scanner.nextInt();
                                facilityService.addFaccility(newVilla, use);
                                System.out.println("Đã thêm villa thành công!");
                                break;
                            case 2:
                                House newHouse = inputNewHouseInfo();
                                System.out.println("Nhập vào số lần đã sử dụng: ");
                                use = scanner.nextInt();
                                facilityService.addFaccility(newHouse, use);
                                System.out.println("Đã thêm house thành công!");
                                break;
                            case 3:
                                Room newRoom = inputNewRoomInfo();
                                System.out.println("Nhập vào số lần đã sử dụng: ");
                                use = scanner.nextInt();
                                facilityService.addFaccility(newRoom, use);
                                System.out.println("Đã thêm room thành công!");
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

    public Booking inputNewBookingInfo() {
        System.out.println("Nhập id booking: ");
        Integer idBooking = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày bắt đầu: ");
        String startDay = inputBirthday();
        System.out.println("Nhập ngày kết thúc: ");
        String finishDay = inputBirthday();
        System.out.println("Nhập id khách hàng: ");
        int idCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = inputName();
        System.out.println("Nhập loại dịch vụ: ");
        String typeService = inputName();
        return new Booking(idBooking, startDay, finishDay, idCustomer, nameService, typeService);
    }

    public Contract inputNewCotractInfo() {
        System.out.println("Nhập id hợp đồng: ");
        int idContract = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập id booking: ");
        int idBooking = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tiền đặt cọc: ");
        Double deposit = inputRentalCots();
        System.out.println("Nhập tiền thanh toán: ");
        Double payment = inputRentalCots();
        System.out.println("Nhập id khách hàng: ");
        int idCustomer = Integer.parseInt(scanner.nextLine());
        return new Contract(idContract, idBooking,deposit, payment, idCustomer);
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
                    //Booking booking = inputNewBookingInfo();
                    //bookingService.addBooking(booking);
                    //System.out.println("Đã thêm booking thành công!");
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