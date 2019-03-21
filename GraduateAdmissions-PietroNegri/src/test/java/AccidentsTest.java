import accidents.Accidents;
import accidents.AccidentsVO;
import accidents.ExtractAccidents;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class AccidentsTest {

    public Accidents accidents;
    public ExtractAccidents extractAccidents;
    public List<AccidentsVO> accidentsList;


    @Before
    public void Start() {
        this.accidentsList = new ArrayList<AccidentsVO>();
        AccidentsVO accidentsVO = getAccidentsVO();

        this.accidentsList.add(accidentsVO);

        extractAccidents = new ExtractAccidents();
        accidents = new Accidents(extractAccidents);

    }

    public AccidentsVO getAccidentsVO() {
        AccidentsVO accidentsVO = new AccidentsVO();


        return accidentsVO;

    }

    @Test
    public void SearchByDistrictName() {


    }
}
