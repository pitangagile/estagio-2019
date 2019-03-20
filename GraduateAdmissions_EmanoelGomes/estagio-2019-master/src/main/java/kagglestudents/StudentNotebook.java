package kagglestudents;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;

    public StudentNotebook(ExtractStudent extractStudent) {
        this.extractStudent = extractStudent;
        this.studentNotebookList = extractStudent.load();
    }

    public Boolean isAnApprovedUser(Integer id) {

        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getId().equals(id)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");



    }

    public Boolean isApprovedBySop(BigDecimal sop){

        BigDecimal compare = new BigDecimal(7);

        if(sop.compareTo(compare)==1 || sop.compareTo(compare)==0){

            return true;

        }else {

            return false;

        }

    }

    public Double percentageapprovedCgpa(){

        BigDecimal nota = new BigDecimal("7.0");
        double contador = 0;

        for(int i=0; i < studentNotebookList.size(); i++){

            if(this.studentNotebookList.get(i).getCgpa().compareTo(nota) == 1 ||
                    this.studentNotebookList.get(i).getCgpa().compareTo(nota) == 0){

                contador++;

            }

        }

        return (double)(contador/400)*100;

    }

    public Double percentageapprovedLor(){

        BigDecimal nota = new BigDecimal("4.0");
        double contador = 0;

        for(int i=0; i < studentNotebookList.size(); i++){

            if(this.studentNotebookList.get(i).getLor().compareTo(nota) == 1 ||
                    this.studentNotebookList.get(i).getSop().compareTo(nota) == 0){

                contador++;

            }

        }

        return ((double)contador/400)*100;

    }

    public Double percentageapprovedSop() {

        BigDecimal nota = new BigDecimal("4.0");
        double contador = 0;

        for(int i=0; i < studentNotebookList.size(); i++){

            if(this.studentNotebookList.get(i).getSop().compareTo(nota) == 1 ||
                    this.studentNotebookList.get(i).getSop().compareTo(nota) == 0){

                contador++;

            }

        }

        return ((double)contador/400)*100;

    }
}
