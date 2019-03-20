package acidentes;

import java.util.List;

public class AccidentsSearch {

    private ExtractAccidents extractAccidents;
    private List<AcidentesVO> accidentsSearchList;

    public AccidentsSearch(ExtractAccidents extractAccidents){

        this.extractAccidents = extractAccidents;
        this.accidentsSearchList = extractAccidents.load();

    }

    public int searchByDistrictName(String districtName){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getDistrictName().equals(districtName)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchByMonth(String month){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getMonth().equals(month)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchByWeekDay(String weekDay){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getWeekDay().equals(weekDay)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchByPartOfDay(String partOfDay){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getPartOfTheDay().equals(partOfDay)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchByMildInjuries(String mildInjuries){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getMildInjuries().equals(mildInjuries)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchBySeriousInjuries(String seriousInjuries){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getSeriousInjuries().equals(seriousInjuries)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchByVictims(String victims){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getVictims().equals(victims)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

    public int searchByVehiclesInvolved(String vehiclesInvolved){

        int i = 0;
        int contador = 0;

        while(i < accidentsSearchList.size()) {

            if (accidentsSearchList.get(i).getVehiclesInvolved().equals(vehiclesInvolved)) {

                System.out.println(accidentsSearchList.get(i).getId());
                contador++;

            }

            i++;

        }

        if(contador>0){

            return contador;

        }else{

            System.out.println("Nenhum registro encontrado");
            return contador;

        }

    }

}
