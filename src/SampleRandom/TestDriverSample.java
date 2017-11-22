package SampleRandom;

// Import all necessary libraries
import support.LLNode;
import ch04.queues.*;
/**
 * Created by Erik on 10/14/2017.
 */

public class TestDriverSample {

    // Use a separate file for your driver to avoid
//   any unnecessary issues with static variables

    public static void main(String[] args) {

        // Create an instance of your queue class
        LinkedQueue<Integer> lq = new LinkedQueue<>();

        // Add some items to the queue
        lq.enqueue(1);
        lq.enqueue(2);
        lq.enqueue(3);

        // Call all of the methods that you've modified
        //  or added to the existing or new queue class
        // Your methods here.
    }
}