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
        //return  false;


    }

    public boolean isAnApprovedUserByCgpa(BigDecimal value, int position) {
        StudentVO student = this.studentNotebookList.get(position);
        if (student.getCgpa().compareTo(value) >= 0) {
            return student.isApproved();
        }
        return false;
    }

    public boolean isAnApprovedUserByLor(BigDecimal value, int position) {
        StudentVO student = this.studentNotebookList.get(position);
        if (student.getLor().compareTo(value) >= 0) {
            return student.isApproved();
        }
        return false;
    }

    public double procentegeOfApprovedByCgpa(BigDecimal value, char operator){
        double percentege = 0.0;
        double aprovados = 0.0;

        for (StudentVO studentVO: studentNotebookList){
            System.out.println(studentVO.getCgpa().compareTo(value));
            switch (operator){
                case '=': {
                    if (studentVO.getCgpa().compareTo(value) == 0){
                        aprovados++;
                    }
                }
                case '>':{
                    if (studentVO.getCgpa().compareTo(value) > 0){
                        aprovados++;
                    }
                }
                case '<':{
                    if (studentVO.getCgpa().compareTo(value) < 0){
                        aprovados++;
                    }
                }
            }
        }
        //System.out.println(aprovados);
        percentege = aprovados/studentNotebookList.size();

        return percentege;
    }

    public double procentegeOfApprovedByLor(BigDecimal value, char operator){
        double percentege = 0.0;
        float aprovados = 0;

        for (StudentVO studentVO: studentNotebookList){
            switch (operator){
                case '=': {
                    if (studentVO.getLor().compareTo(value) == 0){
                        aprovados++;
                    }
                }
                case '>':{
                    if (studentVO.getLor().compareTo(value) == 1){
                        aprovados++;
                    }
                }
                case '<':{
                    if (studentVO.getLor().compareTo(value) == -1){
                        aprovados++;
                    }
                }
            }
        }

        percentege = aprovados/studentNotebookList.size();

        return percentege;
    }
}
