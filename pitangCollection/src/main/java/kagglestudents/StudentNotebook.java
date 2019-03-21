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

    public Boolean isAnApprovedCgpa(BigDecimal cgpa) {

        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getCgpa().equals(cgpa)) {
                return this.studentNotebookList.get(i).isApprovedCgpa();    //poderia ser o método isApproved
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }

    public Boolean isAnApprovedLor(BigDecimal lor) {

        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getLor().equals(lor)) {
                return this.studentNotebookList.get(i).isApprovedLor();    //poderia ser o método isApproved
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }


//    Type:
//    0 -> Menor que '<'
//    1 -> Igual '='
//    2 -> Maior que '>'


    public Double sopPercentage(int type, BigDecimal grade){
        double retorno = 0;
        int contadorGrade = 0;
        int contadorApro = 0;
        BigDecimal sop;
        int comparador=0;

        switch (type){
                case 0:
                    for (int i = 0; i < this.studentNotebookList.size(); i++) {
                        comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                        if(comparador == -1) {
                            contadorGrade++;
                            if(this.studentNotebookList.get(i).isApproved()){
                                contadorApro++;
                            }
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < this.studentNotebookList.size(); i++) {
                        comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                        if(comparador == 0) {
                            contadorGrade++;
                            if(this.studentNotebookList.get(i).isApproved()){
                                contadorApro++;
                            }
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < this.studentNotebookList.size(); i++) {
                        comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                        if(comparador == 1) {
                            contadorGrade++;
                            if(this.studentNotebookList.get(i).isApproved()){
                                contadorApro++;
                            }
                        }
                    }
                    break;
            }
            retorno = (contadorApro*100)/contadorGrade;
            return retorno;
    }

    public Double lorPercentage(int type, BigDecimal grade){
        double retorno = 0;
        int contadorGrade = 0;
        int contadorApro = 0;
        BigDecimal sop;
        int comparador=0;

        switch (type){
            case 0:
                for (int i = 0; i < this.studentNotebookList.size(); i++) {
                    comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                    if(comparador == -1) {
                        contadorGrade++;
                        if(this.studentNotebookList.get(i).isApproved()){
                            contadorApro++;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < this.studentNotebookList.size(); i++) {
                    comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                    if(comparador == 0) {
                        contadorGrade++;
                        if(this.studentNotebookList.get(i).isApproved()){
                            contadorApro++;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < this.studentNotebookList.size(); i++) {
                    comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                    if(comparador == 1) {
                        contadorGrade++;
                        if(this.studentNotebookList.get(i).isApproved()){
                            contadorApro++;
                        }
                    }
                }
                break;
        }
         retorno = (contadorApro*100)/contadorGrade;

        return retorno;
    }

    public Double cgpaPercentage(int type, BigDecimal grade){
        double retorno = 0;
        int contadorGrade = 0;
        int contadorApro = 0;
        BigDecimal sop;
        int comparador=0;

        switch (type){
            case 0:
                for (int i = 0; i < this.studentNotebookList.size(); i++) {
                    comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                    if(comparador == -1) {
                        contadorGrade++;
                        if(this.studentNotebookList.get(i).isApproved()){
                            contadorApro++;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < this.studentNotebookList.size(); i++) {
                    comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                    if(comparador == 0) {
                        contadorGrade++;
                        if(this.studentNotebookList.get(i).isApproved()){
                            contadorApro++;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < this.studentNotebookList.size(); i++) {
                    comparador = this.studentNotebookList.get(i).getSop().compareTo(grade);
                    if(comparador == 1) {
                        contadorGrade++;
                        if(this.studentNotebookList.get(i).isApproved()){
                            contadorApro++;
                        }
                    }
                }
                break;
        }
         retorno = (contadorApro*100)/contadorGrade;
        return retorno;
    }
}