package kagglestudents;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent;
    public List<StudentVO> studentNotebookList;

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

    public Boolean isAnApprovedUser(BigDecimal LOR, BigDecimal CGPA){
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getLor().equals(LOR) &&
            this.studentNotebookList.get(i).getCgpa().equals(CGPA) &&
            this.studentNotebookList.get(i).isApproved()) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }

        //throw new NoSuchElementException("Nao foi encontrado nenhum elemento com ambos os dados!");
        return false;
    }



    public double approvedBySop(double parameterValue){
        double percent = 0.0;
        int qtdOfApproved = 0;
        for(StudentVO svo : studentNotebookList){
            if(svo.getSop().doubleValue() >= parameterValue &&
            svo.isApproved()){

                percent = percent + svo.getSop().doubleValue();
                qtdOfApproved++;
            }
        }


        return (percent/qtdOfApproved)*100;
    }

    public double approvedByLor(double parameterValue){
        double percent = 0.0;
        int qtdOfApproved = 0;
        for(StudentVO svo : studentNotebookList){
            if(svo.getLor().doubleValue() >= parameterValue &&
            svo.isApproved()){
                percent = percent + svo.getLor().doubleValue();
                qtdOfApproved++;
            }
        }


        return (percent/qtdOfApproved)*100;
    }

    public double approvedByCgpa(double parameterValue){
        double percent = 0.0;
        int qtdOfApproved = 0;
        for(StudentVO svo : studentNotebookList){
            if(svo.getCgpa().doubleValue() >= parameterValue &&
            svo.isApproved()){
                percent = percent + svo.getCgpa().doubleValue();
                qtdOfApproved++;
            }
        }


        return (percent/qtdOfApproved)*100;

    }
}
