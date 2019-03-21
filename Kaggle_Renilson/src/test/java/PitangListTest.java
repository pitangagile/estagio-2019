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
    public Integer[] ourListMaster = new Integer[]{2,5};

    public PitangList pitangList;

    @Before
    public void start() {
        this.pitangList = new PitangList();
    }

    @After
    public void end() {
        this.pitangList = new PitangList();
    }

    @Test
    public void size() {
        assertEquals("Dado que não há valores na lista, o tamanho deve continuar {0}",0, this.pitangList.size());
    }

    @Test
    public void add() {
        assertTrue(this.pitangList.add(1));
        assertTrue(this.pitangList.add(2));
    }

    @Test
    public void clear() {

        ourList = new Integer[]{1};
        Whitebox.setInternalState(pitangList, "list", ourList);
        this.pitangList.clear();
        Integer[] array =  (Integer[])Whitebox.getInternalState(pitangList, "list");
        assertEquals("The result must be {0} though some values was added", 0, array.length);
    }


    @Test
    public void addAllEmptyList() {

        // Init an empty list
        PitangList addAllList = new PitangList();

        ourList = new Integer[]{1};

        //Put in my object, at property 'list' ourList that contains {1}
        Whitebox.setInternalState(addAllList, "list", ourList);

        boolean addAllResult = this.pitangList.addAll(addAllList);

        //Given that some values was added, the result must be 'true'
        assertTrue(addAllResult);

        Integer[] addAllArrayResult = (Integer[])Whitebox.getInternalState(pitangList, "list");

        assertEquals(ourList.length,addAllArrayResult.length);


        for (int i = 0; i < ourList.length; i++) {
            if(!addAllArrayResult[i].equals(ourList[i])) {
                fail("Há valores mágicos !");
            }
        }

        assertTrue("Como todos os valores são iguais, o método está correto",true);
    }

    @Test
    public void addAllNotEmptyList() {

        // Init an empty list
        PitangList addAllList = new PitangList();

        ourList = new Integer[]{1};


        //Put in my object, at property 'list' ourList that contains {1}
        Whitebox.setInternalState(addAllList, "list", ourList);

        //Comentários pertinentes
        Whitebox.setInternalState(pitangList, "list", ourListMaster);

        boolean addAllResult = this.pitangList.addAll(addAllList);

        //Given that some values was added, the result must be 'true'
        assertTrue(addAllResult);

        Integer[] addAllArrayResult = (Integer[])Whitebox.getInternalState(pitangList, "list");

        assertEquals(ourList.length+ourListMaster.length,addAllArrayResult.length);


        for (int i = 0; i < ourList.length; i++) {
            if(!addAllArrayResult[ourListMaster.length+i].equals(ourList[i])) {
                fail("Há valores mágicos !");
            }
        }

        for (int i = 0; i < ourListMaster.length; i++) {
            if(!addAllArrayResult[i].equals(ourListMaster[i])) {
                fail("Há valores mágicos !");
            }
        }

        assertTrue(true);



    }
}
