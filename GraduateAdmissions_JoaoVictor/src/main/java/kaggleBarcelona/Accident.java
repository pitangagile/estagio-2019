package kaggleBarcelona;

import java.math.BigDecimal;

public class Accident {
    private Integer id;
    private String district;
    private String neighborhood;
    private String street;
    private String weekday;
    private String month;
    private Integer day;
    private Integer hour;
    private String partOfThDay;
    private Integer mildInjuries;
    private Integer seriousInjuries;
    private Integer victims;
    private Integer vehiclesInvolved;
    private double longitude;
    private double latitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public String getPartOfThDay() {
        return partOfThDay;
    }

    public void setPartOfThDay(String partOfThDay) {
        this.partOfThDay = partOfThDay;
    }

    public Integer getMildInjuries() {
        return mildInjuries;
    }

    public void setMildInjuries(Integer mildInjuries) {
        this.mildInjuries = mildInjuries;
    }

    public Integer getSeriousInjuries() {
        return seriousInjuries;
    }

    public void setSeriousInjuries(Integer seriousInjuries) {
        this.seriousInjuries = seriousInjuries;
    }

    public Integer getVictims() {
        return victims;
    }

    public void setVictims(Integer victims) {
        this.victims = victims;
    }

    public Integer getVehiclesInvolved() {
        return vehiclesInvolved;
    }

    public void setVehiclesInvolved(Integer vehiclesInvolved) {
        this.vehiclesInvolved = vehiclesInvolved;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String toString(){
        return "Acidente: "+this.getId()+" \nData: "+this.getMonth()+"/"+this.getDay()+"\n"+
                this.getStreet()+"\n"+"Vitimas: "+this.getVictims();
    }
}
