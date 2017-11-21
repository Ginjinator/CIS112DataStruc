package Week07;

import ch05.collections.LinkedCollection;
import support.LLNode;

/**
 * Created by Erik on 10/19/2017.
 */
public class SortedLinkedCollection<T extends Comparable> extends LinkedCollection<T> {

    public boolean add(T element) {
        LLNode<T> newNode = new LLNode<>(element);
        location = head;
        int result;

        if (numElements == 0) { //if the list is empty
            head = newNode;
            numElements++;
            return true;
        }else if (numElements == 1) {
            result = (element).compareTo(location.getInfo());
            if (result == 0 || result == 1) {
                head.setLink(newNode);
                numElements++;
                return true;
            } else {
                LLNode<T> temp = head;
                head = newNode;
                head.setLink(temp);
                numElements++;
                return true;
            }
        }

        //while location has a next link
        while (location.getLink() != null) {
            result = (element).compareTo(location.getInfo());
            if (result == 0) {
                newNode.setLink(location.getLink());
                location.setLink(newNode);
                numElements++;
                return true;
            } else if (result == 1) {
                previous = location;
                location = location.getLink();
            } else {
                previous.setLink(newNode);
                newNode.setLink(location);
                numElements++;
                return true;
            }
        }
        location.setLink(newNode);
        numElements++;
        return true;
    }

    public String toString() {
        String output = head.getInfo() + " "; //print the first one
        LLNode temp = head;
        while (temp.getLink() != null) {
            temp = temp.getLink();
            output += temp.getInfo() + " "; //print the next ones in the collection
        }
        return output;
    }
}