package kagglestudents;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class StudentVO {
    //recebe dados e armazena um objeto
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
    }

    public StudentVO(Integer id,Integer gre, Integer toelf, Integer universityRating, BigDecimal sop, BigDecimal lor, BigDecimal cgpa, Byte research, BigDecimal chance ){
        this.id = id;
        this.gre = gre;
        this.toelf = toelf;
        this.universityRating = universityRating;
        this.sop = sop;
        this.lor = lor;
        this.cgpa = cgpa;
        this.research =research;
        this.chance =chance;
    }

    //aprovado
    public Boolean isApproved() {
        BigDecimal media = BigDecimal.valueOf(0.7);
        if(media.compareTo(this.chance) == -1){
             //Significa que a chance está acima da media 0.7
             return  Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }

    public Boolean isApprovedCPGA(){
        BigDecimal media = BigDecimal.valueOf(7.0);
        if(media.compareTo(this.cgpa) == -1){
            //Significa que a chance está acima da media 7.0
            return  Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }

    public Boolean isApprovedLOR(){
        BigDecimal media = BigDecimal.valueOf(3.0);
        if(media.compareTo(this.lor) == -1){
            //Significa que a chance está acima da media 3.0 (media < valor lor)
            return  Boolean.TRUE;
        }
        return  Boolean.FALSE;
    }

    public BigDecimal porcentagemSOP(ArrayList<StudentVO> studentVOS, BigDecimal notaMedia, int op){
        int sopCount =0;
        int aprovadosCount=0;
        BigDecimal media;
        for (StudentVO studentVO : studentVOS) {
            if(studentVO.isApproved()){
                // se o estudante for aprovado checar como fica o porcentual desses estudantes
                if(op==1){
                    //Operação "<"
                    if(studentVO.getSop().compareTo(notaMedia) < 0){
                        // se o sop for MENOR que a media inserida, então eu somo a qtd  (sop<notamedia)
                        sopCount++;
                    }
                } else if(op==2){
                    //Operação "="
                    if(studentVO.getSop().compareTo(notaMedia) == 0){
                        // se o sop for IGUAL que a media inserida, então eu somo a qtd  (sop=notamedia)
                        sopCount++;
                    }
                } else if(op==3){
                    //Operação ">"
                    if(studentVO.getSop().compareTo(notaMedia) > 0){
                        // se o sop for MAIOR que a media inserida, então eu somo a qtd  (sop>notamedia)
                        sopCount++;
                    }
                } else{
                    throw new UnsupportedOperationException("Operação não existente");
                }
                aprovadosCount++;
            }
        }
        //Media vai ser a quantidade de alunos que passaram da validacao com a operacao dividido pela quantidade total de alunos aprovados
        media = BigDecimal.valueOf(sopCount).divide(BigDecimal.valueOf(aprovadosCount), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN);
       return media;
    }

    public BigDecimal porcentagemLOR(ArrayList<StudentVO> studentVOS, BigDecimal notaMedia, int op){
        int lorCount =0;
        int aprovadosCount=0;
        BigDecimal media;
        for (StudentVO studentVO : studentVOS) {
            if(studentVO.isApproved()){
                // se o estudante for aprovado checar como fica o porcentual desses estudantes
                if(op==1){
                    //Operação "<"
                    if(studentVO.getLor().compareTo(notaMedia) < 0){
                        // se o sop for MENOR que a media inserida, então eu somo a qtd  (sop<notamedia)
                        lorCount++;
                    }
                } else if(op==2){
                    //Operação "="
                    if(studentVO.getLor().compareTo(notaMedia) == 0){
                        // se o sop for IGUAL que a media inserida, então eu somo a qtd  (sop=notamedia)
                        lorCount++;
                    }
                } else if(op==3){
                    //Operação ">"
                    if(studentVO.getLor().compareTo(notaMedia) > 0){
                        // se o sop for MAIOR que a media inserida, então eu somo a qtd  (sop>notamedia)
                        lorCount++;
                    }
                }else{
                    throw new UnsupportedOperationException("Operação não existente");
                }
                aprovadosCount++;
            }
        }
        //Media vai ser a quantidade de alunos que passaram da validacao com a operacao dividido pela quantidade total de alunos aprovados
        media = BigDecimal.valueOf(lorCount).divide(BigDecimal.valueOf(aprovadosCount), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN);
        return media;
    }

    public BigDecimal porcentagemCGPA(ArrayList<StudentVO> studentVOS, BigDecimal notaMedia, int op){
        int cpgaCount =0;
        int aprovadosCount=0;
        BigDecimal media;
        for (StudentVO studentVO : studentVOS) {
            if(studentVO.isApproved()){
                // se o estudante for aprovado checar como fica o porcentual desses estudantes
                if(op==1){
                    //Operação "<"
                    if(studentVO.getCgpa().compareTo(notaMedia) < 0){
                        // se o sop for MENOR que a media inserida, então eu somo a qtd  (sop<notamedia)
                        cpgaCount++;
                    }
                } else if(op==2){
                    //Operação "="
                    if(studentVO.getCgpa().compareTo(notaMedia) == 0){
                        // se o sop for IGUAL que a media inserida, então eu somo a qtd  (sop=notamedia)
                        cpgaCount++;
                    }
                } else if(op==3){
                    //Operação ">"
                    if(studentVO.getCgpa().compareTo(notaMedia) > 0){
                        // se o sop for MAIOR que a media inserida, então eu somo a qtd  (sop>notamedia)
                        cpgaCount++;
                    }
                }else{
                    throw new UnsupportedOperationException("Operação não existente");
                }
                aprovadosCount++;
            }
        }
        //Media vai ser a quantidade de alunos que passaram da validacao com a operacao dividido pela quantidade total de alunos aprovados
        media = BigDecimal.valueOf(cpgaCount).divide(BigDecimal.valueOf(aprovadosCount), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_EVEN);
        return media;
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
