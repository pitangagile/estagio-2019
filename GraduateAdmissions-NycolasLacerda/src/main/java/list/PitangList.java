package list;

import java.util.*;


public class PitangList implements List<Integer> {

    public Integer[] list;

    public PitangList() {
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

    public <T> T[] toArray(T[] ts) {
        return null;
    }

    public boolean add(Integer value) {

        Integer[] tempList = this.list.clone();
        this.list = new Integer[this.list.length+1];
        for (int i = 0; i < tempList.length; i++) {
            this.list[i] = tempList[i];
        }
        this.list[this.list.length-1] = value;

        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        return false;
    }

    public boolean addAll(int i, Collection<? extends Integer> collection) {
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    public void clear() {
        this.list = new Integer[0];


    }

    public Integer get(int i) {
        return null;
    }

    public Integer set(int i, Integer integer) {
        return null;
    }

    public void add(int i, Integer integer) {

    }

    public Integer remove(int i) {
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

    public ListIterator<Integer> listIterator(int i) {
        return null;
    }

    public List<Integer> subList(int i, int i1) {
        return null;
    }
}
