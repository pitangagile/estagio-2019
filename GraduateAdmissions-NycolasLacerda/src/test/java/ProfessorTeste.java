import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import persistente.ObjetoPersistenteAbstrato;
import persistente.Professor;

import static org.junit.Assert.assertFalse;

public class ProfessorTeste extends ObjetoPersistenteAbstrato {

    Professor professor;

    @Test(expected = RuntimeException.class,timeout = 1)
    public void test() {



        professor = Mockito.mock(Professor.class);
        Mockito.doReturn(false).when((ObjetoPersistenteAbstrato) professor).salvar();

        Boolean result = professor.salvar();

        Mockito.verify(professor).salvar();

        assertFalse(result);


    }
}
