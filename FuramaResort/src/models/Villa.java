package models;

public class Villa extends Service{
    private String roomStandard;
    private double areaPool;
    private int numberOfFloors;

    public Villa(){

    }
    public Villa(String nameService, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent, String roomStandard, double areaPool, int numberOfFloors){
        super(nameService, areaUse, rentalCosts, maxNumberOfPeople, typeRent);
        this.roomStandard = roomStandard;
        this.areaPool = areaPool;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String toString(){
        return super.toString() + " room standard: "+getRoomStandard()+" area pool: "+getAreaPool()+" number of floors: "+getNumberOfFloors();
    }
}
