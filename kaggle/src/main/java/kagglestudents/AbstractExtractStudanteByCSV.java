package kagglestudents;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExtractStudanteByCSV implements IExtractStudent {

    public List<StudentVO> load(){
        List<StudentVO> lista = new ArrayList<StudentVO>();
        try {
            //csv file containing data
            String strFile = "C:\\Users\\Victor Oliveira\\Downloads\\Admission_Predict.csv";
            CSVReader reader = new CSVReader(new FileReader(strFile));
            reader.skip(1); //pular cabeçalho
            String [] nextLine;
            StudentVO estudante;
            while ((nextLine = reader.readNext()) != null) {
                estudante = new StudentVO();

                estudante.setId(Integer.parseInt(nextLine[0]));
                estudante.setGre(Integer.parseInt(nextLine[1]));
                estudante.setToelf(Integer.parseInt(nextLine[2]));
                estudante.setUniversityRating(Integer.parseInt(nextLine[3]));
                estudante.setSop(new BigDecimal(nextLine[4]));
                estudante.setLor(new BigDecimal(nextLine[5]));
                estudante.setCgpa(new BigDecimal(nextLine[6]));
                estudante.setResearch(new Byte(nextLine[7]));
                estudante.setChance(new BigDecimal(nextLine[8]));

                lista.add(estudante);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
