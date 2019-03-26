package kagglestudents;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;

    public StudentNotebook(ExtractStudent extractStudent) throws IOException {
        this.extractStudent = extractStudent;
        this.studentNotebookList = extractStudent.load();
    }

    public boolean isAnApprovedUser(Integer id) {
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getId().equals(id)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }

        return false;

    }

    public boolean isAnApprovedUser(BigDecimal lor, BigDecimal cgpa){
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getLor().equals(lor) && this.studentNotebookList.get(i).getCgpa().equals(cgpa)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }
        return false;
    }

    public double approvedRateCgpaBiggerThan(BigDecimal cgpa){
        int count = 0;
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getCgpa().doubleValue() > cgpa.doubleValue() && this.studentNotebookList.get(i).isApproved()) {
                count++;
            }

        }
        if(count > 0){
            return ((double)count)/this.studentNotebookList.size();
        }
        else{
            return 0.0;
        }
    }

    public double approvedRateCgpaLesserThan(BigDecimal cgpa){
        int count = 0;
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getCgpa().doubleValue() < cgpa.doubleValue() && this.studentNotebookList.get(i).isApproved()) {
                count++;
            }

        }
        if(count > 0){
            return ((double)count)/this.studentNotebookList.size();
        }
        else{
            return 0.0;
        }
    }

    public double approvedRateCgpaEqualTo(BigDecimal cgpa){
        int count = 0;
        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getCgpa().doubleValue() == cgpa.doubleValue() && this.studentNotebookList.get(i).isApproved()) {
                count++;
            }

        }
        if(count > 0){
            return ((double)count)/this.studentNotebookList.size();
        }
        else{
            return 0.0;
        }
    }


}
