package admissions;

public class CsvAbstract implements ICsv {

    public Boolean approved() {
        return Boolean.TRUE;
    }

    public Boolean CGPAAppoved() {
        return Boolean.TRUE;
    }

    public Boolean LORApproved() {
        return Boolean.TRUE;
    }
}