package models;

public class House extends Service{
    private String roomStandard;
    private int numberOfFloors;

    public House(){

    }
    public House(String nameService, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, int numberOfFloors){
        super(nameService, areaUse, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public String toString(){
        return super.toString() + " room standard: "+getRoomStandard()+" number of floors: "+getNumberOfFloors();
    }
}
