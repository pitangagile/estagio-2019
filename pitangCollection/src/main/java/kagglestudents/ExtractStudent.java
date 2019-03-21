package kagglestudents;

import java.util.List;

public class ExtractStudent extends AbstractExtractStudent {

    @Override
    public List<StudentVO> load() {
        System.out.println("Iniciando processo de importacao do dados dos estudantes");
        return super.load();
    }

}