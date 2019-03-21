
import list.PitangList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import static org.junit.Assert.*;

public class PitangListTest {

    @Mock
    public Integer[] ourList;

    @Mock
    public Integer[] ourListMaster;

    public PitangList pitangList;

    @Before
    public void start(){
        this.pitangList = new PitangList();
    }

    @After
    public void end(){
        this.pitangList = new PitangList();
    }

    @Test
    public void size(){
        assertEquals("Dado que não há valores na lista, o tamanho deve continuar {0}",0, this.pitangList.size());
    }

    @Test
    public void add(){
        assertTrue(this.pitangList.add(1));
        assertTrue(this.pitangList.add(2));
    }

    @Test
    public void clear(){
        ourList = new Integer[]{1};
        Whitebox.setInternalState(this.pitangList, "list", ourList);
        this.pitangList.clear();
        Integer[] array = (Integer[]) Whitebox.getInternalState(this.pitangList,"list");
        assertEquals("O valor deverá ser {0} mesmo se tivesse valores dentro",0, array.length);
    }

    @Test
    public void contains(){
        ourList = new Integer[]{1};
        Whitebox.setInternalState(this.pitangList, "list", ourList);
        this.pitangList.contains(equals(1));
    }

    @Test
    public void addAllEmptyList(){

        //Iniciar um lista vazia
        PitangList addAllList = new PitangList();

        ourList = new Integer[]{1};

        //Colocar no objeto, a propriedade 'list' ourList que contém {1}
        Whitebox.setInternalState(addAllList, "list", ourList);

        boolean addAllResult = this.pitangList.addAll(addAllList);

        //Dado que os valores foram adicionados, o resultade deverá ser 'true'
        assertTrue(addAllResult);

        //2º Teste - Checar se o tamanho é o mesmo
        Integer[] addAllArrayResult = (Integer[]) Whitebox.getInternalState(pitangList, "list");
        assertEquals(ourList.length, addAllArrayResult.length);

        //3º Teste - Checar se os valores estão contidos

        for (int i = 0; i < ourList.length; i++){
            if(!addAllArrayResult[i].equals(ourList[i])){
                fail("Há valores mágicos!");
            }
        }
        assertTrue("Como todos os valores são iguais, o método esá correto", true);
    }

    @Test
    public void addAllNotEmptyList(){
        PitangList addAllList = new PitangList();

        ourList = new Integer[]{1};
        ourListMaster = new Integer[]{2, 5};

        //Colocar no objeto, a propriedade 'list' ourList que contém {1}
        Whitebox.setInternalState(addAllList, "list", ourList);

        //Comentários pertinentes
        Whitebox.setInternalState(this.pitangList, "list", ourListMaster);

        boolean addAllResult = this.pitangList.addAll(addAllList);

        //Dado que os valores foram adicionados, o resultade deverá ser 'true'
        assertTrue(addAllResult);

        Integer[] addAllArrayResult = (Integer[]) Whitebox.getInternalState(this.pitangList, "list");

        assertEquals(ourList.length + ourListMaster.length, addAllArrayResult.length);

        for(int i = 0; i < ourList.length; i++){
            if(!addAllArrayResult[ourList.length+i].equals(ourList[i])){
                fail("Há valores mágicos!");
            }
        }

        for(int i = 0; i < ourListMaster.length; i++){
            if(!addAllArrayResult[i].equals(ourListMaster[i])){
                fail("Há valores mágicos!");
            }
        }

        assertTrue(true);
    }
}