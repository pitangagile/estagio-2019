package acidentes;

public class Main {

    public static void main(String[] args){

        ExtractAccidents extractAccidents = new ExtractAccidents();
        AccidentsSearch accidentsSearch = new AccidentsSearch(extractAccidents);

        System.out.println("Search by district:");
        accidentsSearch.searchByDistrictName("Ciutat Vella");
        System.out.println("\n");
        System.out.println("Search by mild injuries:");
        accidentsSearch.searchByMildInjuries("2");
        System.out.println("\n");
        System.out.println("Search by serious injuries:");
        accidentsSearch.searchBySeriousInjuries("1");
        System.out.println("\n");
        System.out.println("Search by month:");
        accidentsSearch.searchByMonth("June");
        System.out.println("\n");
        System.out.println("Search by part of the day:");
        accidentsSearch.searchByPartOfDay("Morning");
        System.out.println("\n");
        System.out.println("Search by week day:");
        accidentsSearch.searchByWeekDay("Friday");
        System.out.println("\n");
        System.out.println("Search by victims:");
        accidentsSearch.searchByVictims("10");
        System.out.println("\n");
        System.out.println("Search by vehicles involved:");
        accidentsSearch.searchByVehiclesInvolved("6");


    }

}
