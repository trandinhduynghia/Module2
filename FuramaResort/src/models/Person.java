package models;

public abstract class Person {
    private int id;
    private String name;
    private String birthday;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;

    public Person(){

    }
    public Person(int id, String name, String birthday, String gender, String idNumber, String phoneNumber, String email){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString(){
        return "id: "+getId()+" name: "+getName()+" birthday: "+getBirthday()+" gender: "+getGender()+ " id number: "+getIdNumber()
                + " phone number: "+getPhoneNumber()+" email: "+getEmail();
    }
}
