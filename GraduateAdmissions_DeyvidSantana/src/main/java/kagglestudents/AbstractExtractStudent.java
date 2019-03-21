package kagglestudents;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractExtractStudent implements IExtracStudent {

    /*public List<StudentVO> load() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(1);
        studentVO.setCgpa(new BigDecimal(352.00));
        studentVO.setChance(new BigDecimal("25.12"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(256.88));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);

        return Arrays.asList(studentVO);
    }*/

    // Loads the CSV file and calls the method for build student list
    public List<StudentVO> load() {
        
        List<List<String>> records = new ArrayList<List<String>>();
        List<StudentVO> studentsList = new ArrayList<StudentVO>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Deyvid\\Desktop\\Treinamento Pitang\\Admission_Predict.csv"));
            String line;

            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if(!isFirstLine){
                    String[] values = line.split(",");
                    records.add(Arrays.asList(values));
                }
                isFirstLine = false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return buildStudentsList(records);
    }

    // Read the two-dimensional list and calls the method that build a student
    public List<StudentVO> buildStudentsList(List<List<String>> records){

        List<StudentVO> studentVOList = new ArrayList<StudentVO>();
        StudentVO student;

        for (List record: records ) {
            student = buildStudent(record);
            studentVOList.add(student);
        }

        return  studentVOList;
    }

    // Build a student to set it into a student list
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
