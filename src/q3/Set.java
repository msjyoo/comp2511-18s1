package q3;

public interface Set<E> extends Iterable<E>
{
    boolean add(E elem);
    boolean remove(E elem);
    boolean contains(Object o);
    Set<E> union(Set<E> otherSet);
    Set<E> intersection(Set<E> otherSet);
    boolean isSubset(Set<E> otherSet);
    @Override
    boolean equals(Object o);
}
