package kagglestudents;

import java.math.BigDecimal;

public class StudentVO {

    private Integer id;
    private Integer gre;
    private Integer toefl;
    private Integer universityRating;
    private BigDecimal sop;
    private BigDecimal cgpa;
    private Byte research;
    private BigDecimal chance;
    private BigDecimal lor;


    public StudentVO(){
        this.sop = new BigDecimal("0.00").setScale(2);
    }

    public Boolean isApproved() {
        return  Boolean.TRUE;
    }

    public BigDecimal getLor() {
        return lor;
    }

    public void setLor(BigDecimal lor) {
        this.lor = lor;
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

    public Integer getToefl() {
        return toefl;
    }

    public void setToefl(Integer toefl) {
        this.toefl = toefl;
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
