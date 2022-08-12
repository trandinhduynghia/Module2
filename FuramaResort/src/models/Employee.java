package models;

public class Employee extends Person{
    private String level;
    private String location;
    private double wage;

    public Employee(){

    }
    public Employee(int id, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String level, String location, double wage){
        super(id, name, birthday, gender, idNumber, phoneNumber, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
    public String toString(){
        return super.toString() + " level: "+getLevel()+" location: "+getLocation()+" wage: "+getWage();
    }

}
