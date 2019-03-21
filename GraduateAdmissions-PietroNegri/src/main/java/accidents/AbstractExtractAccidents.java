package accidents;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractExtractAccidents implements IAccidentsExtract {

    public List<AccidentsVO> load() {
        AccidentsVO accidentsVO = new AccidentsVO();


        return Arrays.asList(accidentsVO);
    }
}
