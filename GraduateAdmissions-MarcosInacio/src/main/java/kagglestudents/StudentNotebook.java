package kagglestudents;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static kagglestudents.OpcoesSinalComparacao.*;

public class StudentNotebook {

    private Double[] list;

    private ExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;

    public StudentNotebook(ExtractStudent extractStudent) {
        this.list = new Double[0];
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

    public Boolean isApprovedCGPA(BigDecimal cgpa){
        BigDecimal valor10 = new BigDecimal(300);
        for (int i = 0; i < this.studentNotebookList.size(); i++){
            if (this.studentNotebookList.get(i).getCgpa().equals(cgpa))
            {
                if(cgpa.compareTo(valor10)> 0 ){
                    return this.studentNotebookList.get(i).isApproved();
                }

            }
        }

        throw new NoSuchElementException("Nota CGPA baixa");
    }

    public Boolean isApprovedLOR(BigDecimal lor){
        BigDecimal valor4 = new BigDecimal(4.0);
        for (int i = 0; i < this.studentNotebookList.size(); i++){
            if (this.studentNotebookList.get(i).getLor().equals(lor))
            {
                if(lor.compareTo(valor4) >= 0){
                    return this.studentNotebookList.get(i).isApproved();
                }

            }
        }

        throw new NoSuchElementException("Nota LOR baixa");
    }


    public double porcentagemAprovacao(double aDouble, String sinal) {

        double contadorAprovacao = 0;

        switch (OpcoesSinalComparacao.valueOf(sinal)){
            case maior:
                for (int i = 0; i < list.length; i++){
                    if (aDouble > list[i]){
                        contadorAprovacao++;
                    }
                }
                break;
            case menor:
                for (int i = 0; i < list.length; i++){
                    if (aDouble < list[i]){
                        contadorAprovacao++;
                    }
                }
                break;
            case igual:
                for (int i = 0; i < list.length; i++){
                    if (aDouble == list[i]){
                        contadorAprovacao++;
                    }
                }
                break;
        }

        double porcentagemAprovacao = contadorAprovacao / list.length;
        System.out.printf("Porcentagem de aprovação: %.2f\n",porcentagemAprovacao*100);


        return porcentagemAprovacao;
    }

}
