package kagglestudents;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leitor {

    public List<StudentVO> list;

    public Leitor(){}


    public List<StudentVO> lerDoArquivo(){

        List<List<String>> records = new ArrayList<>();
        List<StudentVO> studentsList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/kagglestudents/Admission_Predict.csv"));
           // BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Admission_Predict.csv")));
            String line;
            boolean isFirtsLine = true;
            while ((line = br.readLine()) != null){
                if(!isFirtsLine){
                    String[] values = line.split(",");
                    records.add(Arrays.asList(values));
                }
                isFirtsLine = false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buildListStudents(records);
    }

    public List<StudentVO> buildListStudents(List<List<String>> records){

        List<StudentVO> studentVOList = new ArrayList<>();
        StudentVO student;

        for(List record: records){
            student = buildStudent(record);
            studentVOList.add(student);
        }
        return studentVOList;
    }

    public StudentVO buildStudent(List<String> student){

        StudentVO studentVO = new StudentVO();

        studentVO.setId(Integer.parseInt(student.get(0)));
        studentVO.setGre(Integer.parseInt(student.get(1)));
        studentVO.setToelf(Integer.parseInt(student.get(2)));
        studentVO.setUniversityRating(Integer.parseInt(student.get(3)));
        studentVO.setSop(new BigDecimal(student.get(4)));
        studentVO.setLor(new BigDecimal(student.get(5)));
        studentVO.setCgpa(new BigDecimal(student.get(6)));
        studentVO.setResearch(Byte.valueOf(student.get(7)));
        studentVO.setChance(new BigDecimal(student.get(8)));

        return studentVO;
    }
}
