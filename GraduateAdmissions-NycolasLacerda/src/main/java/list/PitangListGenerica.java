package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PitangListGenerica<T> implements List<T> {

    public T[] list;


    public PitangListGenerica() {
        this.list = (T[])new Object[0];

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

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    public boolean add(T t) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    public boolean addAll(Collection<? extends T> collection) {
        return false;
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    public void clear() {

    }

    public T get(int i) {
        return null;
    }

    public T set(int i, T t) {
        return null;
    }

    public void add(int i, T t) {

    }

    public T remove(int i) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int i) {
        return null;
    }

    public List<T> subList(int i, int i1) {
        return null;
    }
}
