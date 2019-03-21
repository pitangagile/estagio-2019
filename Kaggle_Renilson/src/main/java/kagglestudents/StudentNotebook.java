package kagglestudents;

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

    public float studentsAprovedByCGPA(double cgpa,char operator){
        double totalAproved = 0;
        switch(operator){
            case '=': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getCgpa().doubleValue() == cgpa){
                        totalAproved++;
                    }
                }

            }
            break;
            case '>': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getCgpa().doubleValue() > cgpa){
                        totalAproved++;
                    }
                }
            }
            break;
            case '<': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getCgpa().doubleValue() < cgpa){
                        totalAproved++;
                    }
                }
            }
            break;
        }
        return (float) (totalAproved/this.studentNotebookList.size());
    }
    public float studentsAprovedByLOR(double lor,char operator){
        double totalAproved = 0;
        switch(operator){
            case '=': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getLor().doubleValue() == lor){
                        totalAproved++;
                    }
                }
            }
            break;
            case '>': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getLor().doubleValue() > lor){
                        totalAproved++;
                    }
                }
            }
            break;
            case '<': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getLor().doubleValue() < lor){
                        totalAproved++;
                    }
                }
            }
            break;
        }
        return (float) (totalAproved/this.studentNotebookList.size());
    }

    public float studentsAProvedBySOP(double sop, char operator) {
        double totalAproved = 0;
        switch(operator){
            case '=': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getSop().doubleValue() == sop){
                        totalAproved++;
                    }
                }
            }
            break;
            case '>': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getSop().doubleValue() > sop){
                        totalAproved++;
                    }
                }
            }
            break;
            case '<': {
                for(StudentVO studentVO: this.studentNotebookList){
                    if(studentVO.getSop().doubleValue() < sop){
                        totalAproved++;
                    }
                }
            }
            break;
        }
        return (float) (totalAproved/this.studentNotebookList.size());
    }
}
