package kaggleBarcelona;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class AccidentNotebook {
    private IExtract extractAccidents;
    private List<Accident> lista;

    public AccidentNotebook(IExtract extract){
        extractAccidents = extract;
        lista = extract.load();
    }

    public boolean addAccident(Accident a){
        lista.add(a);
        return true;
    }
    public boolean RemoveAccident(int id){
        if(lista.size()!=0 && lista.size() > id){
            for(int i = 0; i < lista.size(); i++){
                if(lista.get(i).getId() == id){
                    lista.remove(i);
                    return true;
                }
            }
        }
        throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
    }
    public boolean UpdateAccident(int id){
        return true;
    }

    public List<Accident> getByDistrict(String distrito) {
        List<Accident> list = new ArrayList<Accident>();
        for (Accident acid : this.lista) {
            if(acid.getDistrict().equals(distrito)){
                list.add(acid);
            }
        }
        if(list.size() == 0){
            throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
        }
        return list;
    }

    public List<Accident> getByMonth(String mes) {
        List<Accident> list = new ArrayList<Accident>();
        for (Accident acid : this.lista) {
            if(acid.getMonth().equals(mes)){
                list.add(acid);
            }
        }
        if(list.size() == 0){
            throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
        }
        return list;
    }

    public List<Accident> getByWeekDay(String diaSemana) {
        List<Accident> list = new ArrayList<Accident>();
        for (Accident acid : this.lista) {
            if(acid.getWeekday().equals(diaSemana)){
                list.add(acid);
            }
        }
        if(list.size() == 0){
            throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
        }
        return list;
    }

    public List<Accident> getByPartOfTheDay(String turno) {
        List<Accident> list = new ArrayList<Accident>();
        for (Accident acid : this.lista) {
            if(acid.getPartOfThDay().equals(turno)){
                list.add(acid);
            }
        }
        if(list.size() == 0){
            throw new NoSuchElementException("Nao foi encontrado nenhum elemento");
        }
        return list;
    }

    public List<Accident> getByMildInjuries(int mildInjuries, String sinalComparacao) {
        if(sinalComparacao != ">" && sinalComparacao != "=" && sinalComparacao != "<"){
            return null;
        }

        List<Accident> list = new ArrayList<Accident>();
        for (Accident acid : this.lista) {
            if(acid.getMildInjuries() > mildInjuries){
                if(sinalComparacao.equals(">")) {
                    list.add(acid);
                }
            }
            else if(acid.getMildInjuries() == mildInjuries){
                if(sinalComparacao.equals("=")) {
                    list.add(acid);
                }
            }
            else{ //acid < mildInjuries
                if(sinalComparacao.equals("<")) {
                    list.add(acid);
                }
            }
        }
        if(list.size() == 0){
            throw new NoSuchElementException();
        }
        return list;
    }
}
