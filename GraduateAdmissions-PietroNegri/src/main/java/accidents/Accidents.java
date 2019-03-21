package accidents;

import java.util.List;

public class Accidents {


    private ExtractAccidents extractAccidents;
    private List<AccidentsVO> accidentsList;

    public Accidents(ExtractAccidents extractAccidents) {
        this.extractAccidents = extractAccidents;
        this.accidentsList = extractAccidents.load();

    }

    public List<AccidentsVO> SearchByDistrictName(String DistrictName) {


        return null;
    }

    public List<AccidentsVO> SearchByMonth() {

        return null;
    }

    public List<AccidentsVO> SearchByWeekday() {

        return null;
    }

    public List<AccidentsVO> SearchByPartOfTheDay() {

        return null;
    }


}
