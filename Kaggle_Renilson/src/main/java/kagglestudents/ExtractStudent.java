package kagglestudents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExtractStudent extends AbstractExtractStudent {

    @Override
    public List<StudentVO> load(){
        System.out.println("Iniciando processo de importacao do dados dos estudantes");

        String filePath = "src/main/resources/Admission_Predict.csv";
        List<StudentVO> resultList = new ArrayList<StudentVO>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String[] line = bufferedReader.readLine().split(",");

            while (bufferedReader.ready()) {
                line = bufferedReader.readLine().split(",");

                resultList.add(new StudentVO(
                        Integer.valueOf(line[0]), Integer.valueOf(line[1]), Integer.valueOf(line[2]), Integer.valueOf(line[3]),
                        new BigDecimal(Double.valueOf(line[4])), new BigDecimal(Double.valueOf(line[5])), new BigDecimal(Double.valueOf(line[6])),
                        Byte.valueOf(line[7]), new BigDecimal(Double.valueOf(line[8]))));

            }
        }
        catch(IOException e){
            resultList.clear();
        }
        return resultList;
    }

}
