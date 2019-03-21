import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import persistente.ObjetoPersistenteAbstrato;
import persistente.Professor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class PersistentTest {

    ObjetoPersistenteAbstrato professor;

    @Mock
    ObjetoPersistenteAbstrato objetoPersistenteAbstrato;

    @Before
    public void start(){
        initMocks(this);
        this.professor = new Professor();
    }

    @Test
    public void salvarComMockIniciado(){
        // Define how mock should behave
        when(objetoPersistenteAbstrato.salvar()).thenReturn(true);
        // Testing our object
        assertTrue(professor.salvar());
        // Verify if method of mock object has called
        verify(objetoPersistenteAbstrato, atLeastOnce()).salvar();
    }
    @Test(expected = NullPointerException.class)
    public void salvarComMockNaoIniciado(){
        when(objetoPersistenteAbstrato.salvar()).thenThrow(new Exception("Ocorreu uma exceção."));
    }
}
