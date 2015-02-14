/**
 * Created by Ben Aherne.
 * Basic test for the ArrayBasedDeque class.
 */
public class TestArrayBasedDeque {
    public static void main(String[] args) {

        ArrayBasedDeque<Integer> deq = new ArrayBasedDeque<>(7);

        System.out.println("<---------------------isEmpty() Test--------------------->");
        //tests isEmpty() method
        System.out.println("Deque is empty: " + deq.isEmpty());
        deq.insertFirst(1);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        System.out.println("Deque is empty: " + deq.isEmpty());
        deq.removeFirst();
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());

        System.out.println("<---------------------insertFirst() Test--------------------->");
        //tests insertFirst() method
        for (int object = 0; object < 7; object++) {
            deq.insertFirst(object);
            System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        }

        System.out.println("<---------------------removeFirst() Test--------------------->");
        //test removeFirst() method
        for (int object = 0; object < 7; object++) {
            deq.removeFirst();
            System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        }

        System.out.println("<---------------------insertLast() Test--------------------->");
        //test insertLast() method
        for (int object = 0; object < 7; object++) {
            deq.insertLast(object);
            System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        }

        System.out.println("<---------------------removeLast() Test--------------------->");
        //test removeLast() method
        for (int object = 0; object < 7; object++) {
            deq.removeLast();
            System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        }

        System.out.println("<---------------------circular effect overlap test--------------------->");
        deq.insertLast(1);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertLast(2);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertLast(3);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertLast(4);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertLast(5);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertLast(6);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertFirst(19);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertFirst(18);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());
        deq.insertFirst(17);
        System.out.println(deq.getArray() + " ------> front is: " + deq.getFront() + " // end is: " + deq.getRear());

    }
}
