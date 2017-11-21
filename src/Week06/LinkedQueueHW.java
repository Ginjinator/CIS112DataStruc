package Week06;

import ch04.queues.LinkedQueue;
import ch04.queues.QueueUnderflowException;
import support.LLNode;

/**
 * Created by Erik on 10/12/2017.
 */

public class LinkedQueueHW<T> extends LinkedQueue{
    @Override
    public String toString(){
        String output = "";
        LLNode current = front;
        while (current != null){
            output += current.getInfo().toString() + " ";
            current = current.getLink();
        }
        return output.toString();
    }

    public void remove(int count){
        if(count > size()){
            throw new QueueUnderflowException();
        }
        else{
            for(int i = 0; i < count; i++){
                front = front.getLink();
                if(front == null) {
                    rear = null;
                }
                numElements--;
            }
        }
    }

    public boolean swapStart(){
        if (size() < 2){
            return false;
        }
        else{
            LLNode<T> temp = front.getLink();
            front.setLink(temp.getLink());
            temp.setLink(front);
            front = temp;
            return true;
        }
    }

    public boolean swapEnds(){
        LLNode pointer = front;
        LLNode oldRear = rear;
        LLNode oldFront = front;

        for (int i = 2; i < size() ; i++) {
            pointer = pointer.getLink();
        }
        oldRear.setLink(front.getLink());
        pointer.setLink(oldFront);
        oldFront.setLink(null);
        front = oldRear;
        rear = oldFront;
        return true;
    }
}