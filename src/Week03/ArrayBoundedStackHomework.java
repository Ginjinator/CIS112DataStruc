package Week03;

/**
 * Created by Erik on 9/22/2017.
 */

public class ArrayBoundedStackHomework<T> extends ArrayBoundedStack {

    public void popSome(int count){
        for(int i = 0; i <= count; i++){
            if (isEmpty())
                throw new StackUnderflowException("Pop attempted on an empty stack or on a stack smaller than count.");
            else
            {
                elements[topIndex] = null;
                topIndex--;
            }
        }
    }

    public T popTop(){
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on empty stack.");
        else{
            T temp = (T) elements[topIndex];
            elements[topIndex] = null;
            return temp;
        }
    }

    public int size(){
        return elements.length;
    }

    public boolean swapStart(){
        if (elements.length < 2)
            return false;
        else{
            T temp = (T)elements[topIndex];
            elements[topIndex] = elements[topIndex-1];
            elements[topIndex-1] = temp;
            return true;
        }
    }

    @Override
    public String toString(){
        String printStack = null;
        for(int i = 0; i < elements.length; i++){
            printStack += elements[i];
        }
        return printStack;
    }
}
