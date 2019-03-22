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
     
    public StudentVO()	{
    	
    }
    public StudentVO(Integer id, Integer gre, Integer toelf, Integer universityRating, BigDecimal sop, 
    		BigDecimal lor, BigDecimal cgpa, byte research, BigDecimal chance) {
    	this.sop = new BigDecimal("0.00").setScale(2);
    	this.id = id;
    	this.gre = gre;
    	this.toelf = toelf;
    	this.universityRating = universityRating;
    	this.sop = sop;
    	this.lor = lor;
    	this.cgpa = cgpa;
    	this.research = research;
    	this.chance = chance;
    }
    public Boolean isApproved() {
        return  (this.getChance().doubleValue() >= 0.7);
    }


    public void exibeInfo()	{
    	System.out.println("ID: " + this.getId());
    	System.out.println("GRE " + this.getGre());
    	System.out.println("TOEFL " + this.getToelf());
    	System.out.println("University Rating " + this.getUniversityRating());
    	System.out.println("SOP " + this.getSop());
    	System.out.println("LOR " + this.getLor());
    	System.out.println("CGPA " + this.getCgpa() );
    	System.out.println("Research " + this.getResearch());
    	System.out.println("Chance of Admit " + this.getChance());
    }

    public Integer getId() {
        return id;
    }

    public Integer getGre() {
        return gre;
    }

    public Integer getToelf() {
        return toelf;
    }

    public Integer getUniversityRating() {
        return universityRating;
    }

    public BigDecimal getSop() {
        return sop;
    }

    public BigDecimal getCgpa() {
        return cgpa;
    }

    public Byte getResearch() {
        return research;
    }
   
    public BigDecimal getChance() {
        return chance;
    }

	public BigDecimal getLor() {
		return lor;
	}
}
