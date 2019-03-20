package kagglestudents;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractExtractStudent implements IExtracStudent {

    String arquivo = "Admission_Predict.csv";
    BufferedReader bufferedReader = null;
    String linha = "";
    int espera = 0;
    List<StudentVO> lista = new ArrayList<StudentVO>();

    public List<StudentVO> load() {

        try {

            bufferedReader = new BufferedReader(new FileReader(arquivo));
            while ((linha = bufferedReader.readLine())!= null){

                String[] estudante = linha.split(",");
                espera++;
                if(espera>=2){

                    StudentVO studentVO = new StudentVO();
                    studentVO.setId(Integer.parseInt(estudante[0]));
                    studentVO.setCgpa(new BigDecimal(estudante[6]));
                    studentVO.setChance(new BigDecimal(estudante[8]));
                    studentVO.setGre(Integer.parseInt(estudante[1]));
                    studentVO.setResearch(new Byte(Byte.parseByte(estudante[7])));
                    studentVO.setSop(new BigDecimal(estudante[4]));
                    studentVO.setLor(new BigDecimal(estudante[5]));
                    studentVO.setToelf(Integer.parseInt(estudante[2]));
                    studentVO.setUniversityRating(Integer.parseInt(estudante[3]));

                    lista.add(studentVO);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if(bufferedReader != null){

                try {

                    bufferedReader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

        return lista;
    }
}
