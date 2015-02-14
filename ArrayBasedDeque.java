/**
 * Created by Ben Aherne.
 * Implements a circular non-resizable double ended queue that takes a generic object as it's parameter.
 */
public class ArrayBasedDeque<E> implements Deque<E> {
    private final int CAPACITY; // maxiumum deque size
    private E[] dequeArray; // the array
    private int front; // the first elements position
    private int rear; // the last elements position

    /**
     * Constructs the ArrayBasedDeque object
     *
     * @param sizeOfDeque - the maximum number of objects that the array can store.
     */
    public ArrayBasedDeque(int sizeOfDeque) {
        this.CAPACITY = sizeOfDeque;
        dequeArray = (E[]) new Object[CAPACITY];
        front = 0;
        rear = 0;
    }

    /**
     * Gets the first object in the deque without removing it
     *
     * @return the first object in the deque
     */
    @Override
    public E first() {
        return dequeArray[front];
    }

    /**
     * Gets the last object in the deque without removing it
     *
     * @return the last object in the array.
     */
    @Override
    public E last() {
        return dequeArray[rear];
    }

    /**
     * Gets the position of the "first" object in the array
     *
     * @return int - the first position in the array
     */
    public int getFront() {
        return front;
    }

    /**
     * Gets the position of the "last" object in the array
     *
     * @return int - the last position in the array
     */
    public int getRear() {
        return rear;
    }

    /**
     * gets the arrays maximum size
     *
     * @return int - the arrays maximum size
     */
    public int getCapacity() {
        return CAPACITY;
    }

    /**
     * Produces a string of all the objects in the deque as converted with toString().
     *
     * @return a string representing all obj
     * cts in the deque.
     */
    public String getArray() {
        String str = "";
        for (E e : dequeArray) {
            str += e + " ";
        }
        return str;
    }

    /**
     * Inserts the parameter into the first position of the deque.
     *
     * @param element - the object to be pushed into the front of the deque.
     */
    @Override
    public void insertFirst(E element) {
        //if the front is about to overlap with the end, the end is moved back one position.
        if (((front - 1) + CAPACITY) % CAPACITY == rear) {
            rear = ((rear - 1) + CAPACITY) % CAPACITY;
        }
        //moves the start of the array down one position.
        front = (((front - 1) + CAPACITY) % CAPACITY);
        dequeArray[front] = element;

    }

    /**
     * Inserts the parameter into the last position of the deque.
     *
     * @param element - the object to be pushed into the end of the deque.
     */
    @Override
    public void insertLast(E element) {
        //Uses default rear position if the array is current position is empty,
        //if that position contains an object the rear is moved forward one position.
        if (dequeArray[rear] == null) {
            dequeArray[rear] = element;
        } else {
            rear = (((rear + 1)) % CAPACITY);
            dequeArray[rear] = element;
        }
    }

    /**
     * Copies the first object of the deque and deletes the original.
     *
     * @return object - the object at the deques front position.
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        E object = dequeArray[front];
        //deletes the object
        dequeArray[front] = null;
        //If moving the front position forward would overlap the rear of the deque,
        //and if that position is not null, the rear is moved forward one position.
        //If the rear is null then the deque is now empty and the overlap is allowed.
        if (((front + 1) + CAPACITY) % CAPACITY == rear) {
            if (dequeArray[((front + 1) + CAPACITY) % CAPACITY] != null) {
                rear = ((rear + 1) + CAPACITY) % CAPACITY;
            }
        }
        front = ((front + 1) + CAPACITY) % CAPACITY;
        return object;
    }

    /**
     * Copies the last object of the deque and deletes the original.
     *
     * @return object - the object at the deques rear position.
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        //if the current position contains no objects, the deque is made one unit shorter and
        //the rear is moved back one position
        if (dequeArray[rear] == null) {
            rear = ((rear - 1) + CAPACITY) % CAPACITY;
        }
        E temp = dequeArray[rear];
        //deletes the object at the current position
        dequeArray[rear] = null;
        return temp;
    }

    /**
     * Gets the number of objects currently in the deque. Distinct from its capacity.
     *
     * @return int - the number ob objects in the deque.
     */
    @Override
    public int size() {
        return front == rear ? 0 : (((CAPACITY - front + (rear)) % CAPACITY) + 1);
    }

    /**
     * Checks whether or not the deque has an objects stored in it.
     *
     * @return boolean - true for an empty deque false for a non-empty deque.
     */
    @Override
    public boolean isEmpty() {
        //if the front and rear overlap then the queue must be empty
        return front == rear;
    }

}

