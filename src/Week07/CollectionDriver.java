package Week07;

import ch05.collections.LinkedCollection;

/**
 * Created by Erik on 10/19/2017.
 */
public class CollectionDriver {
    public static void main(String[] args) {
        LinkedCollectionsHW<Integer> col = new LinkedCollectionsHW<>();

        col.add(1);
        col.add(2);
        col.add(3);
        col.add(4);
        col.add(5);
        col.add(6);

        System.out.println("LinkedCollectionsHW:");
        System.out.println(col.toString());
        int count = col.count(1);
        System.out.println(count);
        col.removeAll(2);
        System.out.println(col.toString());

        LinkedCollection<Integer> test = new LinkedCollection<>();
        test.add(9);
        test.add(8);
        test.add(7);
        test.add(10);

        SortedLinkedCollection<Integer> sortedCollection = new SortedLinkedCollection<>();

        sortedCollection.add(4);
        sortedCollection.add(1);
        sortedCollection.add(3);
        sortedCollection.add(2);
        sortedCollection.add(5);
        sortedCollection.add(7);
        sortedCollection.add(6);
        sortedCollection.add(8);

        System.out.println("Sorted Collection:");
        System.out.println(sortedCollection.toString());
    }
}