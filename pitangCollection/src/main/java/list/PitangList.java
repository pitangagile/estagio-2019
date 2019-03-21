package list;

import java.util.*;

public class PitangList implements List<Integer>{

    private Integer[] list;

    public PitangList(){
        this.list = new Integer[0];
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<Integer> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean add(Integer value) {
        Integer[] tempList = this.list.clone();
        this.list = new Integer[this.list.length+1]; //NÃO SERIA MELHOR COLOCAR tempList.length+1?
        for (int i = 0; i < tempList.length; i++){
            this.list[i] = tempList[i];
        }
        this.list[this.list.length-1] = value;
        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends Integer> c) {
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

//    public void replaceAll(UnaryOperator<Integer> operator) {
//
//    }

    public void sort(Comparator<? super Integer> c) {

    }

    public void clear() {
        this.list = new Integer[0];
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

//    public Spliterator<Integer> spliterator() {
//        return null;
//    }
}