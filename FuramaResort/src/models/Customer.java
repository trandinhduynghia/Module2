package models;

public class Customer extends Person{
    private String typeCustomer;
    private String address;
    public Customer(){

    }
    public Customer(int id, String name, String birthday, String gender, String idNumber, String phoneNumber, String email, String typeCustomer, String adress){
        super(id, name, birthday, gender, idNumber, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.address = adress;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }
    public String toString(){
        return super.toString()+" type customer: "+getTypeCustomer()+" address: "+getAdress();
    }
}
