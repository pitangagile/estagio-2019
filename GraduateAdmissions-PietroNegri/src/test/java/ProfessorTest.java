import org.junit.Before;
import org.junit.Test;
import persistence.Professor;

import static org.junit.Assert.*;
public class ProfessorTest {

    public Professor professor;

    @Before
    public void start(){
        professor = new Professor();
    }

    @Test
    public void save(){
        assertTrue(professor.save());


    }
}
