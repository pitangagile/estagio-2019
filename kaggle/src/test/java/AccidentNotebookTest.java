import kaggleBarcelona.Accident;
import kaggleBarcelona.AccidentNotebook;
import kaggleBarcelona.ExtractAccidentCSV;
import kaggleBarcelona.IExtract;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.fail;

public class AccidentNotebookTest {

    @Mock
    IExtract extract;
    @Mock
    Accident acidente;
    @Mock
    AccidentNotebook accidentNotebook;

    public List<Accident> criarListaTeste(){
        List<Accident> lista = new ArrayList<Accident>();

        Accident a1 = new Accident();
        a1.setId(1);
        a1.setDistrict("distrito01");
        a1.setMonth("janeiro");
        a1.setWeekday("segunda");
        a1.setPartOfThDay("noite");
        a1.setMildInjuries(3);

        Accident a2 = new Accident();
        a2.setId(2);
        a2.setDistrict("distrito01");
        a2.setMonth("fevereiro");
        a2.setWeekday("quarta");
        a2.setPartOfThDay("noite");
        a2.setMildInjuries(1);

        Accident a3 = new Accident();
        a3.setId(3);
        a3.setDistrict("distrito03");
        a3.setMonth("janeiro");
        a3.setWeekday("quinta");
        a3.setPartOfThDay("noite");
        a3.setMildInjuries(1);

        Accident a4 = new Accident();
        a4.setId(4);
        a4.setDistrict("distrito04");
        a4.setMonth("janeiro");
        a4.setWeekday("sabado");
        a4.setPartOfThDay("noite");
        a4.setMildInjuries(2);

        lista.add(a1);
        lista.add(a2);
        lista.add(a3);
        lista.add(a4);
        return lista;
    }

    @Before
    public void start(){
        extract = Mockito.spy(new ExtractAccidentCSV());
        Mockito.doReturn(criarListaTeste()).when(extract).load();
        accidentNotebook = new AccidentNotebook(extract);
    }

    @Test
    public void addAccidentNaListaVazia(){
        List<Accident> listaVazia = new ArrayList<Accident>();
        Mockito.doReturn(listaVazia).when(extract).load(); //começar com lista vazia
        accidentNotebook = new AccidentNotebook(extract);

        Accident acid = new Accident();
        acid.setId(10);

        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook, "lista");
        Assert.assertEquals(0,lista.size());

        Assert.assertTrue(accidentNotebook.addAccident(acid));

        Assert.assertEquals(1, lista.size());
        Assert.assertEquals(lista.get(0).getId(), acid.getId());
    }

    @Test
    public void addAccident(){
        Accident acid = new Accident();
        acid.setId(10);
        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook, "lista");
        int tam = lista.size();
        accidentNotebook.addAccident(acid);
//        Mockito.verify(lista, Mockito.times(1)).add(acid); //lista não é mock
        Assert.assertEquals(tam+1, lista.size());
        Assert.assertEquals(acid, lista.get(tam));
    }

    @Test
    public void deleteAccidentId(){
        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook, "lista");
        int tam = lista.size();

        accidentNotebook.RemoveAccident(1);

        Assert.assertEquals(tam-1, lista.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteAccidentIdNaListaVazia(){
        List<Accident> listaVazia = new ArrayList<Accident>();
        Mockito.doReturn(listaVazia).when(extract).load();
        accidentNotebook = new AccidentNotebook(extract);

        accidentNotebook.RemoveAccident(10);
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteAccidentIdInexistente(){
        accidentNotebook.RemoveAccident(10);
    }

    @Test
    public void getAccidentByDistrict(){
        List<Accident> lista = accidentNotebook.getByDistrict("distrito01");
        Assert.assertEquals(2,lista.size());
        for (Accident acid : lista) {
            if(!acid.getDistrict().equals("distrito01")){
                fail();
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByDistrictListaVazia(){
        List<Accident> listaVazia = new ArrayList<Accident>();
        Mockito.doReturn(listaVazia).when(extract).load();
        accidentNotebook = new AccidentNotebook(extract);

        accidentNotebook.getByDistrict("distrito01");
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByDistrictInexistente(){

        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook,"lista");
        for (Accident acid : lista) {
            if(acid.getDistrict().equals("distrito8000")){
                fail();
            }
        }
        accidentNotebook.getByDistrict("distrito8000");
        Assert.assertNotEquals(0, lista.size());
    }

    @Test
    public void getAccidentByMonth(){
        List<Accident> lista = accidentNotebook.getByMonth("janeiro");
        Assert.assertEquals(3,lista.size());
        for (Accident acid : lista) {
            if(!acid.getMonth().equals("janeiro")){
                fail();
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByMonthNaListaVazia(){
        List<Accident> listaVazia = new ArrayList<Accident>();
        Mockito.doReturn(listaVazia).when(extract).load();
        accidentNotebook = new AccidentNotebook(extract);

        accidentNotebook.getByMonth("janeiro");
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByMonthInexistente(){
        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook,"lista");
        for (Accident acid : lista) {
            if(acid.getMonth().equals("dezembro")){
                fail();
            }
        }
        accidentNotebook.getByMonth("dezembro");
        Assert.assertNotEquals(0, lista.size());
    }

    @Test
    public void getAccidentByWeekDay(){
        List<Accident> lista = accidentNotebook.getByWeekDay("sabado");
        Assert.assertEquals(1,lista.size());
        for (Accident acid : lista) {
            if(!acid.getWeekday().equals("sabado")){
                fail();
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByWeekDayNaListaVazia(){
        List<Accident> listaVazia = new ArrayList<Accident>();
        Mockito.doReturn(listaVazia).when(extract).load();
        accidentNotebook = new AccidentNotebook(extract);

        accidentNotebook.getByWeekDay("sabado");
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByWeekDayInexistente(){
        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook,"lista");
        for (Accident acid : lista) {
            if(acid.getWeekday().equals("domingo")){
                fail();
            }
        }
        accidentNotebook.getByWeekDay("domingo");
        Assert.assertNotEquals(0, lista.size());
    }

    @Test
    public void getAccidentByPartOfTheDay(){
        List<Accident> lista = accidentNotebook.getByPartOfTheDay("noite");
        Assert.assertEquals(4,lista.size());
        for (Accident acid : lista) {
            if(!acid.getPartOfThDay().equals("noite")){
                fail();
            }
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByPartOfTheDayNaListaVazia(){
        List<Accident> listaVazia = new ArrayList<Accident>();
        Mockito.doReturn(listaVazia).when(extract).load();
        accidentNotebook = new AccidentNotebook(extract);

        accidentNotebook.getByPartOfTheDay("noite");
//        Assert.assertEquals(0, listaVazia.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentByPartOfTheDayInexistente(){
        List<Accident> lista = (List<Accident>) Whitebox.getInternalState(accidentNotebook,"lista");
        for (Accident acid : lista) {
            if(acid.getPartOfThDay().equals("manhã")){
                fail();
            }
        }
        accidentNotebook.getByPartOfTheDay("manhã");
        Assert.assertNotEquals(0, lista.size());
    }

    @Test
    public void getAccidentsByMildInjuriesMaior(){
        List<Accident> listaTeste = (List<Accident>)Whitebox.getInternalState(accidentNotebook, "lista");

        int mildInjuries = 1, cont = 0;
        for (Accident acid:listaTeste) {
            if(acid.getMildInjuries()>mildInjuries){
                cont++;
            }
        }

        List<Accident> lista = accidentNotebook.getByMildInjuries(mildInjuries, ">");
        for (Accident acid:lista) {
            if(!(acid.getMildInjuries()>mildInjuries)){
                fail();
            }
        }

        Assert.assertEquals(cont, lista.size());
    }

    @Test
    public void getAccidentsByMildInjuriesIgual(){
        List<Accident> listaTeste = (List<Accident>)Whitebox.getInternalState(accidentNotebook, "lista");

        int mildInjuries = 1, cont = 0;
        for (Accident acid:listaTeste) {
            if(acid.getMildInjuries()==mildInjuries){
                cont++;
            }
        }

        List<Accident> lista = accidentNotebook.getByMildInjuries(mildInjuries, "=");
        for (Accident acid:lista) {
            if(!(acid.getMildInjuries()==mildInjuries)){
                fail();
            }
        }

        Assert.assertEquals(cont, lista.size());
    }

    @Test
    public void getAccidentsByMildInjuriesMenor(){
        List<Accident> listaTeste = (List<Accident>)Whitebox.getInternalState(accidentNotebook, "lista");

        int mildInjuries = 2, cont = 0;
        for (Accident acid:listaTeste) {
            if(acid.getMildInjuries()<mildInjuries){
                cont++;
            }
        }

        List<Accident> lista = accidentNotebook.getByMildInjuries(mildInjuries, "<");
        for (Accident acid:lista) {
            if(!(acid.getMildInjuries()<mildInjuries)){
                fail();
            }
        }

        Assert.assertEquals(cont, lista.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void getAccidentsByMildInjuriesIgualImposivel(){
        List<Accident> listaTeste = (List<Accident>)Whitebox.getInternalState(accidentNotebook, "lista");

        int mildInjuries = 100, cont = 0;
        for (Accident acid:listaTeste) {
            if(acid.getMildInjuries()==mildInjuries){
                cont++;
            }
        }
        if(cont != 0){
            fail();
        }

        List<Accident> lista = accidentNotebook.getByMildInjuries(mildInjuries, "="); //lançar excessão
    }

    @Test
    public void getAccidentsByMildInjuriesSinalInvalido(){
        int mildInjuries = 2;
        Assert.assertNull(accidentNotebook.getByMildInjuries(mildInjuries, "*"));
        Assert.assertNull(accidentNotebook.getByMildInjuries(mildInjuries, "/"));
    }

}
