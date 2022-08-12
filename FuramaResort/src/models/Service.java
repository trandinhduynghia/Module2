package models;

public abstract class Service {
    private String nameService;
    private double areaUse;
    private double rentalCosts;
    private int maxNumberOfPeople;
    private String typeRent;

    public Service(){

    }
    public Service(String nameService, double areaUse, double rentalCosts, int maxNumberOfPeople, String typeRent){
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.typeRent = typeRent;
    }


    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public String toString(){
        return "name service: "+getNameService()+" area user: "+getAreaUse()+
                " rental costs: "+getRentalCosts()+" max number of people: "+getMaxNumberOfPeople()+" type rent: "+getTypeRent();
    }
}
