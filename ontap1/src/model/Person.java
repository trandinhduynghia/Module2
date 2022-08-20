package model;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String group;
    private String phoneNumber;
    private String sex;
    private String email;
    private String address;

    public Person(){

    }

    public Person(String name, String group, String phoneNumber, String sex, String email, String address){
        this.name = name;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString(){
        return "name: "+getName()+" group: "+getGroup()+" phone number: "+getPhoneNumber()+" sex: "+getSex()+" email: "+getEmail()+" address: "+getAddress();
    }
}
