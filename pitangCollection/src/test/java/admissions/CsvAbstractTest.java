package admissions;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CsvAbstractTest {

    @Mock
    CsvAbstract csv = new Csv();


    @Test
    public void approved() {

        Whitebox.setInternalState(this.csv, "SerialNo", 1);
       // if (Mockito.isNotNull((Class<Boolean>) Whitebox.getInternalState(this.csv, "SerialNo"))) {
            Whitebox.setInternalState(this.csv, "GREScore", 300);
            Double score = (Double) Whitebox.getInternalState(this.csv, "GREScore");
            if (score >= 270) {
                assertTrue(csv.approved());
            } else {
                assertFalse(csv.approved());
            }
        }
    //}


    @Test
    public void CGPAAppoved(){
        Whitebox.setInternalState(this.csv, "CGPA", 8);
        Double score = (Double) Whitebox.getInternalState(this.csv,"CGPA");
        if (score >= 7){
            assertTrue(csv.approved());
        } else {
            assertFalse(csv.approved());
        }
    }

    @Test
    public void LORApproved(){
        Whitebox.setInternalState(this.csv, "LOR", 4.5);
        Double score = (Double) Whitebox.getInternalState(this.csv,"LOR");
        if (score >= 3){
            assertTrue(csv.approved());
        } else {
            assertFalse(csv.approved());
        }
    }

}