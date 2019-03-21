package kagglestudents;

import java.util.List;

public class Main {

    public static void main (String[] args){
        ExtractStudent extractStudent = new ExtractStudent();
        List<StudentVO> studentVO = extractStudent.load();
        StudentNotebook studentNotebook = new StudentNotebook(extractStudent);
    }

}
