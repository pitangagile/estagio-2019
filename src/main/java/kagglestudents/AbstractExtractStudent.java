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

        return Arrays.asList(studentVO);
    }
}
