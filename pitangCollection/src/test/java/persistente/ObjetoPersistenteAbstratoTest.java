package persistente;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class ObjetoPersistenteAbstratoTest {

    @Mock
    public ObjetoPersistenteAbstrato aluno = new Aluno();

    @Test
    public void salvar(){
        assertTrue(aluno.salvar());
    }

}