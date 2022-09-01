package services;

import models.Employee;
import models.Service;
import models.Villa;

import java.util.*;

public class FacilityServiceImpl {
    private Map<Object, Integer> facility = new LinkedHashMap<>();

    public FacilityServiceImpl(){

    }

    public void displayAllFacility(){
        for(Map.Entry<Object, Integer> entry : facility.entrySet()){
            System.out.println(entry.getKey() + " số lần sử dụng:"+entry.getValue());
        }
    }

    public void addFaccility(Object object, int i){
        facility.put(object, i);
    }
}
