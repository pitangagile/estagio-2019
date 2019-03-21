package kagglestudents;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentNotebook {

    private ExtractStudent extractStudent; //uma dependencia
    private ArrayList<StudentVO> studentNotebookList; //lista de estudantes

    public StudentNotebook(ExtractStudent extractStudent) { //passando um extrator de estudante
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
}
