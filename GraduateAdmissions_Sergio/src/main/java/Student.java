public class Student {

    private int serialNum;
    private int GREScore;
    private int TOEFLScore;
    private int uniRating;
    private float SOP;
    private float LOR;
    private float CGPA;
    private boolean research;
    private float chanceOfAdm;

    public Student(int serialNum, int gre, int toefl, int uni, float sop,
                   float lor, float cgpa, boolean research, float chance) {
        this.serialNum = serialNum;
        this.GREScore = gre;
        this.TOEFLScore = toefl;
        this.uniRating = uni;
        this.SOP = sop;
        this.LOR = lor;
        this.CGPA = cgpa;
        this.research = research;
        this.chanceOfAdm = chance;
    }
    public Student (){
    }

    public boolean wasApproved() {
        return chanceOfAdm > 0.70f;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getGREScore() {
        return GREScore;
    }

    public void setGREScore(int GREScore) {
        this.GREScore = GREScore;
    }

    public int getTOEFLScore() {
        return TOEFLScore;
    }

    public void setTOEFLScore(int TOEFLScore) {
        this.TOEFLScore = TOEFLScore;
    }

    public int getUniRating() {
        return uniRating;
    }

    public void setUniRating(int uniRating) {
        this.uniRating = uniRating;
    }

    public float getSOP() {
        return SOP;
    }

    public void setSOP(float SOP) {
        this.SOP = SOP;
    }

    public float getLOR() {
        return LOR;
    }

    public void setLOR(float LOR) {
        this.LOR = LOR;
    }

    public float getCGPA() {
        return CGPA;
    }

    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;
    }

    public boolean isResearch() {
        return research;
    }

    public void setResearch(boolean research) {
        this.research = research;
    }

    public float getChanceOfAdm() {
        return chanceOfAdm;
    }

    public void setChanceOfAdm(float chanceOfAdm) {
        this.chanceOfAdm = chanceOfAdm;
    }
}
