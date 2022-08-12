package models;

public class Room extends Service{
    private String freeService;

    public Room(){

    }
    public Room(String nameService, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent, String freeService){
        super(nameService, areaUse, rentalCosts, maxNumberOfPeople, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    public String toString(){
        return super.toString()+" free service: "+getFreeService();
    }
}
