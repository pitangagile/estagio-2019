package kaggleBarcelona;

import java.util.List;

public class ExtractAccidentCSV extends AbstractExtractAccidentByCSV {

    public List<Accident> load(){
        System.out.println("Recuperando dados de arquivo...");
        return super.load();
    }
}
