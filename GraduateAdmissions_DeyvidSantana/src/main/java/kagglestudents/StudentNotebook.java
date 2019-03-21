package kagglestudents;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent;
    private List<StudentVO> studentNotebookList;
    public enum TestType {ID, SOP, LOR, CGPA};
    public enum ConditionType {GREATER_THEN, LESS_THEN, EQUALS};

    public StudentNotebook(ExtractStudent extractStudent) {
        this.extractStudent = extractStudent;
        this.studentNotebookList = extractStudent.load();
    }

    public Boolean isAnApprovedUser(Integer id, TestType test, double value) {

        for (int i = 0; i < this.studentNotebookList.size(); i++) {
            if(this.studentNotebookList.get(i).getId().equals(id)) {

                switch(test){
                    case ID:
                        return this.studentNotebookList.get(i).isApprovedById();
                    case LOR:
                        return this.studentNotebookList.get(i).isApprovedByLor(value);
                    case CGPA:
                        return this.studentNotebookList.get(i).isApprovedbyCgpa(value);
                    default:
                        break;
                }

            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");

    }


    public double getPercentApprovedUserByValueAndCondition(BigDecimal value, ConditionType condition, TestType test){

        List<StudentVO> studentList = getAllStudentsByValueAndCondition(value, condition, test);
        return studentList.size() * 100 / studentNotebookList.size();

    }

    public List<StudentVO> getAllStudentsByValueAndCondition(BigDecimal value, ConditionType condition, TestType test){
        List<StudentVO> studentList = new ArrayList<StudentVO>();

        for (StudentVO studentVo: studentNotebookList ) {
            switch(test){

                case SOP:

                    switch (condition){
                        case GREATER_THEN:
                            if(studentVo.getSop().compareTo(value) == 1){
                                studentList.add(studentVo);
                            }
                            break;
                        case LESS_THEN:
                            if(studentVo.getSop().compareTo(value) == -1){
                                studentList.add(studentVo);
                            }
                            break;
                        case EQUALS:
                            if(studentVo.getSop().compareTo(value) == 0){
                                studentList.add(studentVo);
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case LOR:

                    switch (condition){
                        case GREATER_THEN:
                            if(studentVo.getLor().compareTo(value) == 1){
                                studentList.add(studentVo);
                            }
                            break;
                        case LESS_THEN:
                            if(studentVo.getLor().compareTo(value) == -1){
                                studentList.add(studentVo);
                            }
                            break;
                        case EQUALS:
                            if(studentVo.getLor().compareTo(value) == 0){
                                studentList.add(studentVo);
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case CGPA:

                    switch (condition){
                        case GREATER_THEN:
                            if(studentVo.getCgpa().compareTo(value) == 1){
                                studentList.add(studentVo);
                            }
                            break;
                        case LESS_THEN:
                            if(studentVo.getCgpa().compareTo(value) == -1){
                                studentList.add(studentVo);
                            }
                            break;
                        case EQUALS:
                            if(studentVo.getCgpa().compareTo(value) == 0){
                                studentList.add(studentVo);
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        }

        return studentList;
    }
}
