/**
 * Created by Ben Aherne.
 * Outlines all methods that must be created by any deque classes
 */
public interface Deque<E> {
    public E first();

    public E last();

    public void insertFirst(E element);

    public void insertLast(E element);

    public E removeFirst();

    public E removeLast();

    public int size();

    public boolean isEmpty();

}
