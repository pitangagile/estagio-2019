package student;

import java.math.BigDecimal;
import java.util.ArrayList;
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
            if (this.studentNotebookList.get(i).getId().equals(id)) {
                return this.studentNotebookList.get(i).isApproved();
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");


    }

    public boolean isAnApprovedUserByCgpa(BigDecimal value) {

        for (StudentVO studentVO : studentNotebookList) {
            if (studentVO.getCgpa().compareTo(value) == 0) {
                return studentVO.isApproved();
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }

    public boolean isAnApprovedUserByLor(BigDecimal value) {

        for (StudentVO studentVO : studentNotebookList) {
            if (studentVO.getLor().compareTo(value) == 0) {
                return studentVO.isApproved();
            }
        }

        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");

    }

    public double percentApprovedBySop(BigDecimal value, char op) {
        List<StudentVO> approvedlist = new ArrayList<StudentVO>();

        for (StudentVO studentVO : studentNotebookList) {
            if (studentVO.isApproved()) {
                switch (op) {
                    case '=':
                        if (studentVO.getSop().compareTo(value) == 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    case '<':
                        if (studentVO.getSop().compareTo(value) < 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    case '>':
                        if (studentVO.getSop().compareTo(value) > 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    default:
                        throw new NullPointerException("operando Invalido");

                }
            }
        }

        double approvespercent = ((double)approvedlist.size() / (double)studentNotebookList.size()) *100;

        return approvespercent;
    }

    public double percentApprovedByLor(BigDecimal value, char op) {
        List<StudentVO> approvedlist = new ArrayList<StudentVO>();

        for (StudentVO studentVO : studentNotebookList) {
            if (studentVO.isApproved()) {
                switch (op) {
                    case '=':
                        if (studentVO.getLor().compareTo(value) == 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    case '<':
                        if (studentVO.getLor().compareTo(value) < 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    case '>':
                        if (studentVO.getLor().compareTo(value) > 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    default:
                        throw new NullPointerException("operando Invalido");

                }
            }
        }

        double approvespercent = ((double)approvedlist.size() / (double)studentNotebookList.size()) *100;

        return approvespercent;
    }

    public double percentApprovedByCgpa(BigDecimal value, char op) {
        List<StudentVO> approvedlist = new ArrayList<StudentVO>();

        for (StudentVO studentVO : studentNotebookList) {
            if (studentVO.isApproved()) {
                switch (op) {
                    case '=':
                        if (studentVO.getCgpa().compareTo(value) == 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    case '<':
                        if (studentVO.getCgpa().compareTo(value) < 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    case '>':
                        if (studentVO.getCgpa().compareTo(value) > 0) {
                            approvedlist.add(studentVO);
                        }
                        break;

                    default:
                        throw new NullPointerException("operando Invalido");

                }
            }
        }

        double approvespercent = ((double)approvedlist.size() / (double)studentNotebookList.size()) *100;

        return approvespercent;
    }

}
