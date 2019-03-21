import list.PitangList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PitangListTest {

    @Mock
    public Integer[] ourListMaster = new Integer[]{2,5};

    @Mock
    public Integer[] ourList;

    public PitangList list;


    @Before
    public void start(){
        list = new PitangList();
    }

    @After
    public void end(){
        list = new PitangList();
    }

    @Test
    public void size(){
        assertEquals( 0, list.size());
    }

    @Test
    public void add(){
        assertTrue(list.add(1));
        assertTrue(list.add(2));

    }

    @Test
    public void clear(){
        ourList = new Integer[]{1};
        Whitebox.setInternalState(list, "list", ourList);
        this.list.clear();
        Integer[] array = (Integer[]) Whitebox.getInternalState(list, "list");
        assertEquals( 0, array.length);
    }

    @Test
    public void contains(){
        ourList = new Integer[]{1, 3, 8};
        Whitebox.setInternalState(list, "list", ourList);
        assertTrue(list.contains(1));
        assertTrue(list.contains(8));
    }

    @Test
    public void addallEmptyList(){

        PitangList new_list = new PitangList();
        ourList = new Integer[]{1, 3, 8};

        Whitebox.setInternalState(new_list, "list", ourList);
        assertTrue(list.addAll(new_list));

        Integer[] NewListElement = (Integer[]) Whitebox.getInternalState(list, "list");
        assertEquals( ourList.length, NewListElement.length);

        for (int i = 0; i < ourList.length ; i++) {
            if(!NewListElement[i].equals(ourList[i])) {
                fail("Valores diferentes !");
            }
        }

        assertTrue("Como todos os valores são iguais, o método está correto", true);
    }

    @Test
    public void addallNotEmptyList(){

        PitangList new_list = new PitangList();
        ourList = new Integer[]{1, 3, 8};

        Whitebox.setInternalState(new_list, "list", ourList);

        Whitebox.setInternalState(list, "list", ourListMaster);

        assertTrue(list.addAll(new_list));

        Integer[] NewListElement = (Integer[]) Whitebox.getInternalState(list, "list");
        assertEquals( ourList.length + ourListMaster.length, NewListElement.length);

        for (int i = 0; i < ourListMaster.length ; i++) {
            if(!NewListElement[i].equals(ourListMaster[i])) {
                fail("Valores diferentes !");
            }
        }

        for (int i = 0; i < ourList.length ; i++) {
            if(!NewListElement[ourListMaster.length + i].equals(ourList[i])) {
                fail("Valores diferentes !");
            }
        }

        assertTrue("Como todos os valores são iguais, o método está correto", true);
    }

    @Test
    public void containsall(){
        ourList = new Integer[]{1,2,8};

        Whitebox.setInternalState(list, "list", ourList);

        assertTrue(list.containsAll(Arrays.asList(1)));
        assertTrue(list.containsAll(Arrays.asList(2)));
        assertTrue(list.containsAll(Arrays.asList(8)));
        assertTrue(list.containsAll(Arrays.asList(1,2,8)));

        assertFalse(list.containsAll(Arrays.asList(1,5)));
        assertFalse(list.containsAll(Arrays.asList(6)));

    }

    @Test
    public void isEmpty(){

        ourList = new Integer[]{1,3,5};
        assertTrue("lista inicializada vazia, logo deve ser verdadeiro", list.isEmpty());

        Whitebox.setInternalState(list,"list", ourList);
        assertFalse("lista com {1} elemento, logo o retorno deve ser falso", list.isEmpty());


    }

    @Test
    public void removeObject(){
        ourList = new Integer[]{1,2,5};

        Whitebox.setInternalState(list, "list", ourList);

        assertTrue(list.remove(ourList[0]));
    }

}
