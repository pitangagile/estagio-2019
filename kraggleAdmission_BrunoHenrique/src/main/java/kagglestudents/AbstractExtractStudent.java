package kagglestudents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractExtractStudent implements IExtracStudent {

    public List<StudentVO> load() {
        try{
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/bruno/Downloads/Admission_Predict_Ver1.1.csv"));
            ArrayList<StudentVO> list = new ArrayList<StudentVO>();

            line = bufferedReader.readLine();
            line = bufferedReader.readLine();//desconsidera o cabeçalho!

            while(line != null){
                //System.out.println(line);
                String[] content = line.split(",");
                StudentVO studentVO = new StudentVO();
                for(int i = 0; i < content.length; i++){
                    studentVO.setId(Integer.parseInt(content[0]));
                    studentVO.setGre(Integer.parseInt(content[1]));
                    studentVO.setToefl(Integer.parseInt(content[2]));
                    studentVO.setUniversityRating(Integer.parseInt(content[3]));
                    studentVO.setSop(new BigDecimal(content[4]));
                    studentVO.setLor(new BigDecimal(content[5]));
                    studentVO.setCgpa(new BigDecimal(content[6]));
                    studentVO.setResearch(new Byte(content[7]));
                    studentVO.setChance(new BigDecimal(content[8]));

                    list.add(studentVO);
                }
                line = bufferedReader.readLine();
            } 


            return list;
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;

    }
}
