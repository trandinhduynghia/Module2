package services;

import exception.UserException;
import models.House;
import models.Room;
import models.Service;
import models.Villa;
import validate1.Validator;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl {
    Scanner scanner = new Scanner(System.in);
     private Map<Service, Integer> facility = new LinkedHashMap<>();

    public FacilityServiceImpl(){

    }

    public void displayAllFacility(){
        for(Map.Entry<Service, Integer> entry : facility.entrySet()){
            System.out.println(entry.getKey() + " số lần sử dụng:"+entry.getValue());
        }
    }

    public void addVilla(){
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = null;
        while (true){
            try {
                nameService = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích: ");
        double areaUse = Validator.validateArea();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = Validator.validateRentalCots();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = Validator.validateMaxNumberOfPeople();
        System.out.println("Nhập loại thuê: ");
        String typeRent = null;
        while (true){
            try {
                typeRent = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = null;
        while (true){
            try {
                roomStandard = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích hồ bơi: ");
        Double areaPool = Validator.validateArea();
        System.out.println("Nhập số lầu: ");
        int numberOfFloors = Validator.validateNumberOfFloors();
         Villa villa = new Villa(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, roomStandard, areaPool, numberOfFloors);
        System.out.println("Nhập vào số lần đã sử dụng: ");
        int use = Integer.parseInt(scanner.nextLine());
        facility.put(villa,use);
        System.out.println("Đã thêm villa thành công!");
    }

    public void addHouse(){
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = null;
        while (true){
            try {
                nameService = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích: ");
        double areaUse = Validator.validateArea();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = Validator.validateRentalCots();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = Validator.validateMaxNumberOfPeople();
        System.out.println("Nhập loại thuê: ");
        String typeRent = null;
        while (true){
            try {
                typeRent = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập tiêu chuẩn phòng: ");
        String roomStandard = null;
        while (true){
            try {
                roomStandard = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập số lầu: ");
        int numberOfFloors = Validator.validateNumberOfFloors();
        House house = new House(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, roomStandard, numberOfFloors);
        System.out.println("Nhập vào số lần đã sử dụng: ");
        int use = Integer.parseInt(scanner.nextLine());
        facility.put(house,use);
        System.out.println("Đã thêm house thành công!");
    }

    public void addRoom(){
        System.out.println("Nhập tên dịch vụ: ");
        String nameService = null;
        while (true){
            try {
                nameService = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập diện tích: ");
        double areaUse = Validator.validateArea();
        System.out.println("Nhập chi phí thuê: ");
        double rencalCosts = Validator.validateRentalCots();
        System.out.println("Nhập số người tối đa: ");
        int maxNumberOfPeople = Validator.validateMaxNumberOfPeople();
        System.out.println("Nhập loại thuê: ");
        String typeRent = null;
        while (true){
            try {
                typeRent = Validator.validateName();
                break;
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Nhập dịch vụ miễn phí: ");
        String freeService = scanner.nextLine();
        Room room = new  Room(nameService, areaUse, rencalCosts, maxNumberOfPeople, typeRent, freeService);
        System.out.println("Nhập vào số lần đã sử dụng: ");
        int use = Integer.parseInt(scanner.nextLine());
        facility.put(room,use);
        System.out.println("Đã thêm room thành công!");
    }

}
