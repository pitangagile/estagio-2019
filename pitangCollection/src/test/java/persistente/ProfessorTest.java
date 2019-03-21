package persistente;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ProfessorTest {

    @Mock
    ObjetoPersistenteAbstrato prof = new Professor();

    Professor professor;

    @Test
    public void salvar(){
        assertTrue(prof.salvar());
    }

    @Test(expected = RuntimeException.class, timeout = 1)
    public void test(){
        professor = Mockito.mock(Professor.class);
        Mockito.doReturn(false).when((ObjetoPersistenteAbstrato) professor).salvar();

        Boolean result = professor.salvar();

        Mockito.verify(professor).salvar();

        assertFalse(result);

    }

}