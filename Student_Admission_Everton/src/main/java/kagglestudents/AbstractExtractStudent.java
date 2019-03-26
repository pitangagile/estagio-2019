package kagglestudents;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractExtractStudent implements IExtracStudent {

    public List<StudentVO> load() throws IOException {
        String fileName = "C:\\Users\\Everton\\Downloads\\Admission_Predict.csv";
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<StudentVO> studentVOS = new ArrayList<StudentVO>();

        String line;
        while((line = bufferedReader.readLine()) != null){
            if(line.contains("S")){

            }else{
                String[] students = line.split(",");
                StudentVO studentVO = new StudentVO();
                studentVO.setId((Integer.parseInt(students[0])));
                studentVO.setGre(Integer.parseInt(students[1]));
                studentVO.setToelf(Integer.parseInt(students[2]));
                studentVO.setUniversityRating(Integer.parseInt(students[3]));
                studentVO.setSop(new BigDecimal(Double.parseDouble(students[4])));
                studentVO.setLor(new BigDecimal(Double.parseDouble(students[5])));
                studentVO.setCgpa(new BigDecimal(Double.parseDouble(students[6])));
                studentVO.setResearch(Byte.parseByte(students[7]));
                studentVO.setChance(new BigDecimal(Double.parseDouble(students[8])));

                studentVOS.add(studentVO);
            }

        }

        return studentVOS;
    }
}
