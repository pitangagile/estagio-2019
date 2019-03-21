package accidents;

public class AccidentsVO {

    private int ID;
    private String districtName;
    private String neighborhoodName;
    private String street;
    private String weekday;
    private String month;
    private int day;
    private int hour;
    private String partOfTheDay;
    private int mildInjuries;
    private int seriousInjuries;
    private int victims;
    private int vehiclesInvolved;
    private long longitude;
    private long latitude;



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getNeighborhoodName() {
        return neighborhoodName;
    }

    public void setNeighborhoodName(String neighborhoodName) {
        this.neighborhoodName = neighborhoodName;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getPartOfTheDay() {
        return partOfTheDay;
    }

    public void setPartOfTheDay(String partOfTheDay) {
        this.partOfTheDay = partOfTheDay;
    }

    public int getMildInjuries() {
        return mildInjuries;
    }

    public void setMildInjuries(int mildInjuries) {
        this.mildInjuries = mildInjuries;
    }

    public int getSeriousInjuries() {
        return seriousInjuries;
    }

    public void setSeriousInjuries(int seriousInjuries) {
        this.seriousInjuries = seriousInjuries;
    }

    public int getVictims() {
        return victims;
    }

    public void setVictims(int victims) {
        this.victims = victims;
    }

    public int getVehiclesInvolved() {
        return vehiclesInvolved;
    }

    public void setVehiclesInvolved(int vehiclesInvolved) {
        this.vehiclesInvolved = vehiclesInvolved;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}
