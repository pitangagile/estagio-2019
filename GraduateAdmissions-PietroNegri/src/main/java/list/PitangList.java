package list;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PitangList implements List<Integer> {

    private Integer[] list;

    public PitangList() {
        this.list = new Integer[0];
    }

    public int size() {
        return list.length;
    }

    public boolean isEmpty() {
        if (list.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contains(Object o) {

        for (int index = 0; list.length > index; index++) {
            if (list[index].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public Iterator<Integer> iterator() {
        return null;
    }

    public Object[] toArray() {
        return this.list;
    }

    public <T> T[] toArray(T[] a) {

        return null;
    }

    public boolean add(Integer value) {
        Integer[] tempList = this.list.clone();
        this.list = new Integer[this.list.length + 1];
        for (int i = 0; i < tempList.length; i++) {
            this.list[i] = tempList[i];
        }
        this.list[this.list.length - 1] = value;

        return true;
    }

    public boolean remove(Object o) {


        return false;
    }

    public boolean containsAll(Collection<?> c) {
        boolean check = false;

        // checar se todos os valores da collection 'C' pertencem a Lista
        for (Object valueCheck : c) {
            for (Integer value : list) {
                //se os valores forem iguais a variavel "check" se torna 'true' para monstrar que o valor de 'C' pertente a Lista
                if (value.equals(valueCheck)) {
                    check = true;
                    break;
                }
            }
            //caso nenhum valor tenha sido encontrado anteriormente, o check vai se encontrar em False e algum valor de 'C' n pertence a lista
            if (check != true) {
                return false;
            } else {
                check = false;
            }

        }
        return true;
    }

    public boolean addAll(Collection<? extends Integer> c) {
        Integer[] new_list = new Integer[list.length + c.size()];
        for (int i = 0; i < list.length; i++) {
            new_list[i] = list[i];
        }

        int index = list.length;

        for (Integer value : c) {

            new_list[index] = value;
            index++;
        }

        list = new_list.clone();
        return true;
    }

    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {
        list = new Integer[0];
    }

    public Integer get(int index) {
        return null;
    }

    public Integer set(int index, Integer element) {
        return null;
    }

    public void add(int index, Integer element) {

    }

    public Integer remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<Integer> listIterator() {
        return null;
    }

    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    public List<Integer> subList(int fromIndex, int toIndex) {
        return null;
    }
}
