package kagglestudents;

import java.util.ArrayList;

public class ExtractStudent extends AbstractExtractStudent {
    //classe concreta

    @Override
    public ArrayList<StudentVO> load() {
        System.out.println("Iniciando processo de importacao do dados dos estudantes");
        return super.load();
    }

}
