package Week07;

import ch05.collections.LinkedCollection;
import support.LLNode;

/**
 * Created by Erik on 10/18/2017.
 */
public class LinkedCollectionsHW<T> extends LinkedCollection{
    @Override
    public String toString(){
        String output = "";
        LLNode current = head;
        while(!isEmpty() && current != null){
            output += current.getInfo().toString() + " ";
            current = current.getLink();
        }
        return output;
    }

    //returns a count of the numbers of elements in the collection
    //such that e.equals(target) is true
    public int count(T target){
        int count = 0;
        location = head;
        found = false;

        while (!found)
        {
            if (location.getInfo().equals(target))  // if they match
            {
                count++;
                found = true;   //set found to true, ending the loop
            }
            else    //continue looping, adding to the counter each loop
            {
                previous = location;
                location = location.getLink();
                count++;
            }
        }
        return count;
    }

    //remove all the elements from the collection
    //such that e.equals(target) is true
    public void removeAll(T target){
        location = head;
        while(!location.getInfo().equals(target)){
            head = head.getLink();
            location = head;
        }
    }

    //creates and returns a new LinkedCollection object
    //that is a combination of both LinkedCollection objects
    public LinkedCollection<T> combine(LinkedCollection<T> other){
        LinkedCollection<T> newCol = this;
        LLNode otherLocation = other.head;

        while(otherLocation != null){
            LLNode<T> newNode = otherLocation;
            newNode.setLink(head);
            head = newNode;
            numElements++;
            otherLocation = otherLocation.getLink();
        }
        return newCol;
    }
}
