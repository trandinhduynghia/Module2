package models;

public class Contract {
    private int idContract;
    private int idBooking;
    private double deposit;
    private double payment;
    private int idCustomer;
    public Contract(){

    }
    public Contract(int idContract, int idBooking, double deposit, double payment, int idCustomer){
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.payment = payment;
        this.idCustomer = idCustomer;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    public String toString(){
        return "id contract: "+getIdContract()+" id booking: "+getIdBooking()+" deposit: "+getDeposit()+
                " payment: "+getPayment()+" id customer: "+getIdCustomer();
    }
}
