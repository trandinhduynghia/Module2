package models;

public class Booking {
    private int idBooking;
    private String startDay;
    private String finishDay;
    private int idCustomer;
    private String nameService;
    private String typeService;
    public Booking(){

    }
    public Booking(int idBooking, String startDay, String finishDay, int idCustomer, String nameService, String typeService){
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.finishDay = finishDay;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getFinishDay() {
        return finishDay;
    }

    public void setFinishDay(String finishDay) {
        this.finishDay = finishDay;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }
    public String toString(){
        return "id booking: "+getIdBooking()+" star day: "+getStartDay()+" finish day: "+getFinishDay()+
                " id customer: "+getIdCustomer()+" name service: "+getNameService()+" type service: "+getTypeService();
    }
}
