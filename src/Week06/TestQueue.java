package Week06;

import ch04.queues.*;
import support.LLNode;

/**
 * Created by Erik on 10/13/2017.
 */
public class TestQueue extends LinkedQueueHW {
    public static void main(String[] args) {
        LinkedQueueHW<Integer> q = new LinkedQueueHW<>();
        CircularLinkedQueue<Integer> cQ = new CircularLinkedQueue<>();

        /*LLNode<Integer> one = new LLNode<>(1);
        LLNode<Integer> two = new LLNode<>(2);
        LLNode<Integer> three = new LLNode<>(3);
        LLNode<Integer> four = new LLNode<>(4);
        LLNode<Integer> five = new LLNode<>(5);
        LLNode<Integer> six = new LLNode<>(6);
        LLNode<Integer> seven = new LLNode<>(7);
        LLNode<Integer> eight = new LLNode<>(8);
        LLNode<Integer> nine = new LLNode<>(9);

        q.enqueue(one);
        q.enqueue(two);
        q.enqueue(three);
        q.enqueue(four);
        q.enqueue(five);
        q.enqueue(six);
        q.enqueue(seven);
        q.enqueue(eight);
        q.enqueue(nine);*/

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);

        System.out.println(q.toString());
        q.swapStart();
        q.swapEnds();
        System.out.println(q.toString());
        q.remove(4);
        System.out.println(q.toString());

        cQ.enqueue(11);
        cQ.enqueue(12);
        cQ.enqueue(13);
        cQ.enqueue(14);

        System.out.println(cQ.toString());
    }
}