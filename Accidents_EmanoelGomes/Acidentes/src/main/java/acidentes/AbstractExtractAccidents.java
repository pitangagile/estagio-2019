package acidentes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExtractAccidents implements IExtractAccidents{

        String arquivo = "accidents_2017.csv";
        BufferedReader bufferedReader = null;
        String linha  = "";
        int espera = 0;
        List<AcidentesVO> acidentes = new ArrayList<AcidentesVO>();

        public List<AcidentesVO> load(){

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

                        acidentes.add(acidentesVO);

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

            return acidentes;

        }

}
