package kagglestudents;

import java.io.IOException;
import java.util.List;

public class ExtractStudent extends AbstractExtractStudent {

    @Override
    public List<StudentVO> load() throws IOException {
        System.out.println("Iniciando processo de importacao do dados dos estudantes");
        return super.load();
    }

}
