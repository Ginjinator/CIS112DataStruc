package Week11;

import ch09.priorityQueues.*;
import java.util.Comparator;

public class UnsortedArrayPriQ<T> implements PriQueueInterface<T> {

    private final int DEFCAP = 100;
    protected T [] elements;
    protected int numElements;
    protected Comparator<T> comp;

    public UnsortedArrayPriQ(){
        elements = (T[]) new Object[DEFCAP];
        comp = new Comparator<T>() {
            public int compare(T element1, T element2) {return ((Comparable)element1).compareTo(element2);}
        };
    }

    @Override
    public void enqueue(T element) {
        if(!isFull()){
            int index = numElements;
            elements[index] = element;
        }
        else{
            throw new PriQOverflowException("enqueue attempted on a full array");
        }
    }

    @Override
    public T dequeue() {
        if(!isEmpty()){
            T temp = elements[numElements - 1];
            elements[numElements - 1] = null;
            numElements--;
            return temp;
        }
        else{
            throw new PriQUnderflowException("dequeue attempted on an empty priority queue");
        }
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}