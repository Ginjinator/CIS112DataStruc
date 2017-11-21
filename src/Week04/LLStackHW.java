package Week04;

import ch02.stacks.LinkedStack;
import ch02.stacks.StackUnderflowException;
import support.LLNode;

/**
 * Created by Erik on 9/28/2017.
 */

public class LLStackHW<T> extends LinkedStack{

    public void popSome(int count){
        for(int i = 0; i < count; i++){
            if(isEmpty())
                throw new StackUnderflowException("Pop attempted on an empty stack or on a stack smaller than count.");
            else
                top = top.getLink();
        }
    }

    public T popTop(){
        if (isEmpty())
            throw new StackUnderflowException("Pop attempted on empty stack.");
        else {
            T temp = (T) top;
            top = top.getLink();
            return temp;
        }

    }

    public int size(){
        int out = 0;
        LLNode current = top;
        while (current != null){
            out++;
            current.getLink();
        }
        return out;
    }

    public boolean swapStart(){
        if (this.size() < 2)
            return false;
        else {
            LLNode<T> temp = top.getLink();
            top.setLink(temp.getLink());
            temp.setLink(this.top);
            top = temp;
            return true;
        }
    }

    @Override
    public String toString(){
        String printStack = "";
        LLNode current = top;
        while (current != null){
            printStack += current.getInfo().toString() + " ";
            current = current.getLink();
        }
        return printStack;
    }
}