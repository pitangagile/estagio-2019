package kaggleBarcelona;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractExtractAccidentByCSV implements IExtract {

    public List<Accident> load(){
        List<Accident> lista = new ArrayList<Accident>();
        try {
            //csv file containing data
            String strFile = "C:\\Users\\Victor Oliveira\\Downloads\\accidents_2017.csv";
            CSVReader reader = new CSVReader(new FileReader(strFile));
            reader.skip(1); //pular cabeçalho
            String [] nextLine;
            Accident acidente;
            while ((nextLine = reader.readNext()) != null) {
                acidente = new Accident();

                acidente.setId(Integer.parseInt(nextLine[0])); //problemas com o tipo do dado
                acidente.setDistrict(nextLine[1]);
                acidente.setNeighborhood(nextLine[2]);
                acidente.setStreet(nextLine[3]);
                acidente.setWeekday(nextLine[4]);
                acidente.setMonth(nextLine[5]);
                acidente.setDay(Integer.parseInt(nextLine[6]));
                acidente.setHour(Integer.parseInt(nextLine[7]));
                acidente.setPartOfThDay(nextLine[8]);
                acidente.setMildInjuries(Integer.parseInt(nextLine[9]));
                acidente.setSeriousInjuries(Integer.parseInt(nextLine[10]));
                acidente.setVictims(Integer.parseInt(nextLine[11]));
                acidente.setVehiclesInvolved(Integer.parseInt(nextLine[12]));
                acidente.setLongitude(Double.parseDouble(nextLine[13]));
                acidente.setLatitude(Double.parseDouble(nextLine[14]));

                lista.add(acidente);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }
}
