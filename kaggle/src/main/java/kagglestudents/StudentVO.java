package kagglestudents;

import java.math.BigDecimal;

public class StudentVO { //padrão VO

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

    public Boolean isApproved() {
//        return  Boolean.TRUE;
        if(this.chance.compareTo(new BigDecimal(0.7)) >= 0){
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

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public BigDecimal getLor() {
        return lor;
    }

    public void setLor(BigDecimal lor) {
        this.lor = lor;
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
