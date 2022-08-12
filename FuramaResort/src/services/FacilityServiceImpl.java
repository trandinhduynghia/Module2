package services;

import models.Employee;
import models.Service;
import models.Villa;

import java.util.*;

public class FacilityServiceImpl {
    private Map<Object, Integer> facility = new LinkedHashMap<>();

    public FacilityServiceImpl(){

    }

    public FacilityServiceImpl(Map<Object, Integer> facility){
        this.facility = facility;
    }

    public void displayAllFacility(){
        for(Map.Entry<Object, Integer> entry : facility.entrySet()){
            System.out.println(entry.getKey() + " số lần sử dụng:"+entry.getValue());
        }
    }
    public void addFaccility(Object object, int i){
        facility.put(object, i);
    }

    public static void main(String[] args) {
        Villa villa = new Villa("villa", 70, 800, 10, "villa", "villa", 70, 3);
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.addFaccility(villa, 0);
        facilityService.displayAllFacility();
    }
}
