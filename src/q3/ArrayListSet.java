package q3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @invariant (all elements are distinct)
 */
public class ArrayListSet<E> implements Set<E>
{
    private ArrayList<E> list = new ArrayList<>();

    @Override
    public boolean add(E elem) {
        if (list.contains(elem)) return false;
        list.add(elem);
        return true;
    }

    @Override
    public boolean remove(E elem) {
        if (!list.contains(elem)) return false;
        list.remove(elem);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Set<E> union(Set<E> otherSet) {
        ArrayListSet<E> s = new ArrayListSet<>();

        for (E e : list) {
            s.add(e);
        }

        for (E e : otherSet) {
            s.add(e);
        }

        return s;
    }

    @Override
    public Set<E> intersection(Set<E> otherSet) {
        ArrayListSet<E> s = new ArrayListSet<>();

        for (E e : list) {
            if (otherSet.contains(e)) s.add(e);
        }

        return s;
    }

    @Override
    public boolean isSubset(Set<E> otherSet) {
        for (E e : otherSet) {
            if (!list.contains(e)) return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Set)) return false;
        Set<?> s = (Set<?>) o;
        for (Object x : list) {
            if (!s.contains(x)) return false;
        }
        for (Object x : s) {
            if (!list.contains(x)) return false;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}

/*
    The class invariant is enforced because distinctiveness is checked
    everywhere that the class modifies the underlying data structure.

    Therefore it is impossible for a duplicate element to be entered into the
    underlying data structure.
 */