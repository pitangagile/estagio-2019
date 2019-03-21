package kagglestudents;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import static java.lang.Byte.valueOf;

public abstract class AbstractExtractStudent implements IExtractStudent {

    //implementação de como carrega o objeto.
    public ArrayList<StudentVO> load() {

        String file = "Admission_Predict.csv";
        BufferedReader reader;
        ArrayList<StudentVO> students = new ArrayList<StudentVO>();


        {
            try {
                reader = new BufferedReader(new FileReader(file));
                String line;
                Boolean primeiraLinha = true;
                int i=0;
                while ((line = reader.readLine()) != null) {
                    if(primeiraLinha){
                        primeiraLinha=false;
                        continue;
                    }
                    String[] linhaSeparada = line.split(",");
                    StudentVO studentVO = new StudentVO();
                    studentVO.setId(Integer.valueOf(linhaSeparada[0]));
                    studentVO.setGre(Integer.valueOf(linhaSeparada[1]));
                    studentVO.setToelf(Integer.valueOf(linhaSeparada[2]));
                    studentVO.setUniversityRating(Integer.valueOf(linhaSeparada[3]));
                    studentVO.setSop(new BigDecimal(linhaSeparada[4]));
                    studentVO.setLor(new BigDecimal(linhaSeparada[5]));
                    studentVO.setCgpa(new BigDecimal(linhaSeparada[6]));
                    studentVO.setResearch(valueOf(linhaSeparada[7]));
                    studentVO.setChance(new BigDecimal(linhaSeparada[8]));

                    students.add(i,studentVO);
                    i++;

                }
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return students;
    }
}
