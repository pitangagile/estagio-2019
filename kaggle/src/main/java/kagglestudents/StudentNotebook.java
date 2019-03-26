package kagglestudents;

import javafx.beans.binding.BooleanExpression;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private IExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;

    public StudentNotebook(IExtractStudent extractStudent) {
        this.extractStudent = extractStudent;
        this.studentNotebookList = extractStudent.load();
    }

    public Boolean isAnApprovedUserId(Integer id) {

        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getId().equals(id)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }
        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }
    public Boolean isAnApprovedUserCGPA(BigDecimal cgpa) {
        //são aprovados somente aqueles com chance maior que 70%
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getCgpa().equals(cgpa)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }
        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }
    public Boolean isAnApprovedUserLOR(BigDecimal lor){
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getLor().equals(lor)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }
        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }
    public BigDecimal percentualAprovacaoSOP(BigDecimal sop, String sinalComparacao){
        if(sinalComparacao != ">" && sinalComparacao != "=" && sinalComparacao != "<"){
            return null;
        }

        double cont = 0, total = 0;
        for(int i = 0 ; i < studentNotebookList.size(); i++){
            if(studentNotebookList.get(i).getSop().compareTo(sop) > 0) {
                if (sinalComparacao.equals(">")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
            else if(studentNotebookList.get(i).getSop().compareTo(sop) == 0) {
                if (sinalComparacao.equals("=")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
            else { // < 0
                if (sinalComparacao.equals("<")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
        }
        double perc;
        if(cont != 0){ //evitar divisão por zero
            perc = (cont/total) * 100;
        }
        else{
            perc = 0;
        }
        return new BigDecimal(perc);
    }

    public BigDecimal percentualAprovacaoLOR(BigDecimal lor, String sinalComparacao){
        if(sinalComparacao != ">" && sinalComparacao != "=" && sinalComparacao != "<"){
            return null;
        }

        double cont = 0, total = 0;
        for(int i = 0 ; i < studentNotebookList.size(); i++){
            if(studentNotebookList.get(i).getLor().compareTo(lor) > 0) {
                if (sinalComparacao.equals(">")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
            else if(studentNotebookList.get(i).getLor().compareTo(lor) == 0) {
                if (sinalComparacao.equals("=")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
            else { // < 0
                if (sinalComparacao.equals("<")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
        }
        double perc;
        if(cont != 0){ //evitar divisão por zero
            perc = (cont/total) * 100;
        }
        else{
            perc = 0;
        }
        return new BigDecimal(perc);
    }
    public BigDecimal percentualAprovacaoCGPA(BigDecimal cgpa, String sinalComparacao){
        if(sinalComparacao != ">" && sinalComparacao != "=" && sinalComparacao != "<"){
            return null;
        }

        double cont = 0, total = 0;
        for(int i = 0 ; i < studentNotebookList.size(); i++){
            if(studentNotebookList.get(i).getCgpa().compareTo(cgpa) > 0) {
                if (sinalComparacao.equals(">")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
            else if(studentNotebookList.get(i).getCgpa().compareTo(cgpa) == 0) {
                if (sinalComparacao.equals("=")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
            else { // < 0
                if (sinalComparacao.equals("<")) {
                    total++;
                    if (studentNotebookList.get(i).isApproved()) {
                        cont++;
                    }
                }
            }
        }
        double perc;
        if(cont != 0){ //evitar divisão por zero
            perc = (cont/total) * 100;
        }
        else{
            perc = 0;
        }
        return new BigDecimal(perc);
    }
}
