package kagglestudents;

import java.util.List;

public class ExtractStudentCSV extends AbstractExtractStudanteByCSV {

    @Override
    public List<StudentVO> load() {
        System.out.println("Iniciando processo de importacao do CSV dos estudantes");
        return super.load();
    }
}
