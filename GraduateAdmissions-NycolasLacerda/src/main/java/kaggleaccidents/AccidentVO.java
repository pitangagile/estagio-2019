package kaggleaccidents;

import java.math.BigDecimal;

public class AccidentVO {


  private String id;
  private String districtName;
  private String neighborhoodName;
  private String street;
  private String weekday;
  private String month;
  private Integer day;
  private Integer hour;
  private String partOfTheDay;
  private Integer mildInjuries;
  private Integer seriousinjuries;
  private Integer victims;
  private Integer vehiclesInvolved;
  private BigDecimal longitude;
  private BigDecimal  latitude;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public String getPartOfTheDay() {
    return partOfTheDay;
  }

  public void setPartOfTheDay(String partOfTheDay) {
    this.partOfTheDay = partOfTheDay;
  }

  public Integer getMildInjuries() {
    return mildInjuries;
  }

  public void setMildInjuries(Integer mildInjuries) {
    this.mildInjuries = mildInjuries;
  }

  public Integer getSeriousinjuries() {
    return seriousinjuries;
  }

  public void setSeriousinjuries(Integer seriousinjuries) {
    this.seriousinjuries = seriousinjuries;
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

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }
}
