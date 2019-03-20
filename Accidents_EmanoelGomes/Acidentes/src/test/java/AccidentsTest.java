import acidentes.AccidentsSearch;
import acidentes.AcidentesVO;
import acidentes.ExtractAccidents;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccidentsTest {

    String arquivo = "accidents_2017.csv";
    BufferedReader bufferedReader = null;
    String linha = "";
    int espera = 0;

@Mock

AccidentsSearch accidentsSearch;
ExtractAccidents extractAccidents;
List<AcidentesVO> list;

@Before

    public void start(){

        extractAccidents = new ExtractAccidents();
        accidentsSearch = new AccidentsSearch(extractAccidents);
        this.list = new ArrayList<AcidentesVO>();

    try {

        bufferedReader = new BufferedReader(new FileReader(arquivo));
        while((linha = bufferedReader.readLine())!=null){

            String[] acidente = linha.split(",");
            espera++;
            if(espera>=2){

                AcidentesVO acidentesVO = new AcidentesVO();
                acidentesVO.setId(acidente[0].replaceAll("\"",""));
                acidentesVO.setDistrictName(acidente[1].replaceAll("\"",""));
                acidentesVO.setNeighborhoodName(acidente[2].replaceAll("\"",""));
                acidentesVO.setStreet(acidente[3].replaceAll("\"",""));
                acidentesVO.setWeekDay(acidente[4].replaceAll("\"",""));
                acidentesVO.setMonth(acidente[5].replaceAll("\"",""));
                acidentesVO.setDay(acidente[6].replaceAll("\"",""));
                acidentesVO.setHour(acidente[7]);
                acidentesVO.setPartOfTheDay(acidente[8].replaceAll("\"",""));
                acidentesVO.setMildInjuries(acidente[9]);
                acidentesVO.setSeriousInjuries(acidente[10]);
                acidentesVO.setVictims(acidente[11]);
                acidentesVO.setVehiclesInvolved(acidente[12]);
                acidentesVO.setLongitude(acidente[13]);
                acidentesVO.setLatitude(acidente[14]);

                list.add(acidentesVO);

            }

        }

    }catch (FileNotFoundException e){

        e.printStackTrace();

    }catch (IOException e){

        e.printStackTrace();

    }finally {

        if(bufferedReader != null){

            try {

                bufferedReader.close();

            }catch (IOException e){

                e.printStackTrace();

            }

        }

    }

}




@Test

    public void searchByDistrictNameFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getDistrictName().equals("Unknown")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador,accidentsSearch.searchByDistrictName("Unknown"));

    }

@Test

    public void searchByDistrictNameNotFound(){

        Assert.assertEquals(0,accidentsSearch.searchByDistrictName("b"));

    }

    @Test

    public void searchByMonthFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getMonth().equals("June")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchByMonth("June"));

    }

    @Test

    public void searchByMonthNotFound(){

        Assert.assertEquals(0, accidentsSearch.searchByMonth("b"));

    }

    @Test

    public void searchByPartOfDayFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getPartOfTheDay().equals("Morning")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchByPartOfDay("Morning"));

    }

    @Test

    public void searchByPartOfDayNotFound(){

        Assert.assertEquals(0,accidentsSearch.searchByPartOfDay("b"));

    }

    @Test

    public void searchByMildInjuriesFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getMildInjuries().equals("2")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchByMildInjuries("2"));

    }

    @Test

    public void searchByMildInjuriesNotFound(){

        Assert.assertEquals(0, accidentsSearch.searchByMildInjuries("20"));

    }

    @Test

    public void searchBySeriousInjuriesFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getSeriousInjuries().equals("1")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchBySeriousInjuries("1"));

    }

    @Test

    public void searchBySeriousInjuriesNotFound(){

        Assert.assertEquals(0, accidentsSearch.searchBySeriousInjuries("20"));

    }

    @Test

    public void searchByVictimsFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getVictims().equals("10")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchByVictims("10"));

    }

    @Test

    public void searchByVictimsNotFound(){

        Assert.assertEquals(0, accidentsSearch.searchByVictims("20"));

    }

    @Test

    public void searchByVehiclesInvolvedFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getVehiclesInvolved().equals("6")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchByVehiclesInvolved("6"));

    }

    @Test

    public void searchByVehiclesInvolvedNotFound(){

        Assert.assertEquals(0, accidentsSearch.searchByVehiclesInvolved("20"));

    }

    @Test

    public void searchByWeekDayFounded(){

        int contador = 0;
        int i = 0;

        while(i<list.size()){

            if(list.get(i).getWeekDay().equals("Friday")){

                contador++;

            }

            i++;

        }

        Assert.assertEquals(contador, accidentsSearch.searchByWeekDay("Friday"));

    }

    @Test

    public void searchByWeekDayNotFound(){

        Assert.assertEquals(0,accidentsSearch.searchByWeekDay("a"));

    }

}
