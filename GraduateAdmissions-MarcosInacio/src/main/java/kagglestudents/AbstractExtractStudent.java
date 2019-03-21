package kagglestudents;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractExtractStudent implements IExtracStudent {

    public List<StudentVO> load() {
        StudentVO studentVO = new StudentVO();
        studentVO.setId(1);
        studentVO.setCgpa(new BigDecimal(352.00));
        studentVO.setChance(new BigDecimal("25.12"));
        studentVO.setGre(254);
        studentVO.setResearch(new Byte((byte) '0'));
        studentVO.setSop(new BigDecimal(256.88));
        studentVO.setToelf(254);
        studentVO.setUniversityRating(544);
        studentVO.setLor(new BigDecimal("4.5"));

        StudentVO studentVO2 = new StudentVO();
        studentVO2.setId(2);
        studentVO2.setCgpa(new BigDecimal(352.00));
        studentVO2.setChance(new BigDecimal("25.12"));
        studentVO2.setGre(254);
        studentVO2.setResearch(new Byte((byte) '0'));
        studentVO2.setSop(new BigDecimal(256.88));
        studentVO2.setToelf(254);
        studentVO2.setUniversityRating(544);
        studentVO2.setLor(new BigDecimal("4"));

        return Arrays.asList(studentVO);
    }
}
