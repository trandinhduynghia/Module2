package controllers;

import models.*;
import services.BookingServiceImpl;
import services.CustomerServiceImpl;
import services.EmployeeServiceImpl;
import services.FacilityServiceImpl;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class FuramaController {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FuramaController furamaController = new FuramaController();
        furamaController.run();
    }
    public void run(){
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl();
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
                    employeeManager(employeeService);
                    break;
                case 2:
                    costomerManager(customerService);
                    break;
                case 3:
                    facilityManagement(facilityService);
                    break;
                case 4:
                    bookingManagement(bookingService);
                    break;
                case 5:
                    System.out.println("1. Display list customers use service");
                    System.out.println("2. Display list customers get voucher");
                    System.out.println("3. Return main menu");
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

    public static Employee inputNewEmployeeInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập id nhân viên:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthday = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập số CMND: ");
        String idNumber = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập trình độ: ");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí: ");
        String location = scanner.nextLine();
        System.out.println("Nhập lương: ");
        Double wage = scanner.nextDouble();
        return new Employee(id, name, birthday, gender, idNumber, phoneNumber, email, level, location, wage);
    }

    public static void employeeManager(EmployeeServiceImpl employeeService) {
        int choose1 = -1;
        do{
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employees");
            System.out.println("3. Edit employees");
            System.out.println("4. Return main menu");
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

    public static Customer inputNewCustomerInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập id khách hàng:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String birthday = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.println("Nhập số CMND: ");
        String idNumber = scanner.nextLine();
        System.out.println("Nhập số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập email: ");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng: ");
        String typeCustomer = scanner.nextLine();
        System.out.println("Nhập địa chị: ");
        String adress = scanner.nextLine();
        return new Customer(id, name, birthday, gender, idNumber, phoneNumber, email, typeCustomer, adress);
    }

    public static void costomerManager(CustomerServiceImpl customerService) {
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

    public static Villa inputNewVillaInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập diện tích: ");
        double areaUse = scanner.nextDouble();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = scanner.nextDouble();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại thuê: ");
        String typeRent = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Nhập diện tích hồ bơi: ");
        Double areaPool = scanner.nextDouble();
        System.out.println("Nhập số lầu: ");
        int numberOfFloors = scanner.nextInt();
        return new Villa(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, roomStandard, areaPool, numberOfFloors);
    }

    public static House inputNewHouseInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập diện tích: ");
        double areaUse = scanner.nextDouble();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = scanner.nextDouble();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại thuê: ");
        String typeRent = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = scanner.nextLine();
        System.out.println("Nhập số lầu: ");
        int numberOfFloors = scanner.nextInt();
        return new House(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, roomStandard, numberOfFloors);
    }

    public static Room inputNewRoomInfo() {
        scanner = new Scanner(System.in);
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập diện tích: ");
        double areaUse = scanner.nextDouble();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = scanner.nextDouble();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập loại thuê: ");
        String typeRent = scanner.nextLine();
        System.out.println("Nhập dịch vụ miễn phí: ");
        String freeService = scanner.nextLine();
        return new Room(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, freeService);
    }

    public static void facilityManagement(FacilityServiceImpl facilityService) {
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

    public static Booking inputNewBookingInfo() {
        System.out.println("Nhập id booking: ");
        Integer idBooking = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ngày bắt đầu: ");
        String startDay = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc: ");
        String finishDay = scanner.nextLine();
        System.out.println("Nhập id khách hàng: ");
        int idCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = scanner.nextLine();
        System.out.println("Nhập loại dịch vụ: ");
        String typeService = scanner.nextLine();
        return new Booking(idBooking, startDay, finishDay, idCustomer, nameService, typeService);
    }

    public static Contract inputNewCotractInfo() {
        System.out.println("Nhập id hợp đồng: ");
        int idContract = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập id booking: ");
        int idBooking = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tiền đặt cọc: ");
        Double deposit = scanner.nextDouble();
        System.out.println("Nhập tiền thanh toán: ");
        Double payment = scanner.nextDouble();
        System.out.println("Nhập id khách hàng: ");
        int idCustomer = Integer.parseInt(scanner.nextLine());
        return new Contract(idContract, idBooking,deposit, payment, idCustomer);
    }

    public static void bookingManagement(BookingServiceImpl bookingService) {
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
                    Booking booking = inputNewBookingInfo();
                    bookingService.addBooking(booking);
                    System.out.println("Đã thêm booking thành công!");
                    break;
                case 2:
                    bookingService.displayAllBooking();
                    break;
                case 3:
                    Contract contract = inputNewCotractInfo();
                    bookingService.addContract(contract);
                    break;
                case 4:
                    bookingService.displayAllContract();
                    break;
                case 5:
                    break;
            }
        }while (choose4 != 6);
    }

}