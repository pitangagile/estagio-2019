package kagglestudents;

import java.math.BigDecimal;

public class StudentVO {

    private Integer id;
    private Integer gre;
    private Integer toelf;
    private Integer universityRating;
    private BigDecimal sop;
    private BigDecimal lor;
    private BigDecimal cgpa;
    private Byte research;
    private BigDecimal chance;


    public StudentVO(){
        this.sop = new BigDecimal("0.00").setScale(2);
    }

    public StudentVO(Integer id, Integer gre, Integer toelf, Integer universityRating, BigDecimal sop, BigDecimal lor, BigDecimal cgpa, BigDecimal chance) {
        this.id = id;
        this.gre = gre;
        this.toelf = toelf;
        this.universityRating = universityRating;
        this.sop = sop;
        this.lor = lor;
        this.cgpa = cgpa;
        this.chance = chance;
    }

    public Boolean isApprovedById() {
        return  Boolean.TRUE;
    }

    public Boolean isApprovedByLor(double value){

        // Checks if student is aprroved by SOP/LOR
        // 0 is similar to equal the big decimal
        // 1 is similar to greater than the big decimal

        if(this.lor.compareTo(new BigDecimal(value)) == 0 ||
                this.lor.compareTo(new BigDecimal(value)) == 1){
            return true;
        }

        return false;
    }

    public Boolean isApprovedbyCgpa(double value){

        // Checks if student is aprroved by CGPA
        // 0 is similar to equal the big decimal
        // 1 is similar to greater than the big decimal

        if(this.cgpa.compareTo(new BigDecimal(value)) == 0 ||
                this.cgpa.compareTo(new BigDecimal(value)) == 1){
            return true;
        }

        return false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGre() {
        return gre;
    }

    public void setGre(Integer gre) {
        this.gre = gre;
    }

    public Integer getToelf() {
        return toelf;
    }

    public void setToelf(Integer toelf) {
        this.toelf = toelf;
    }

    public Integer getUniversityRating() {
        return universityRating;
    }

    public void setUniversityRating(Integer universityRating) {
        this.universityRating = universityRating;
    }

    public BigDecimal getSop() {
        return sop;
    }

    public void setSop(BigDecimal sop) {
        this.sop = sop;
    }

    public BigDecimal getLor() {
        return lor;
    }

    public void setLor(BigDecimal lor) {
        this.lor = lor;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public void setCgpa(BigDecimal cgpa) {
        this.cgpa = cgpa;
    }

    public Byte getResearch() {
        return research;
    }

    public void setResearch(Byte research) {
        this.research = research;
    }

    public BigDecimal getChance() {
        return chance;
    }

    public void setChance(BigDecimal chance) {
        this.chance = chance;
    }
}
