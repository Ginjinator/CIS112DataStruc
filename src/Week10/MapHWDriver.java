package Week10;

import ch08.maps.*;

public class MapHWDriver {
    public static void main(String[] args) {
        MapHW<Integer, String> test = new MapHW<>(10);
        ArrayListMap<Integer, String> compare = new ArrayListMap<>();

        System.out.println("Expect: " + compare.put(1, "Steven") + "  :  " + test.put(1, "Steven"));
        System.out.println("Expect: " + compare.put(2, "Erik") + "  :  " + test.put(2, "Erik"));
        System.out.println("Expect: " + compare.put(3, "Saucy") + "  :  " + test.put(3, "Saucy"));
        System.out.println("Expect: " + compare.put(4, "Peter") + "  :  " + test.put(4, "Peter"));
        System.out.println("Expect: " +  compare.put(1, "Memes") + "  :  " + test.put(1, "Memes"));
        System.out.println("Expect: " +   compare.remove(2) + "  :  " + test.remove(2));
        System.out.println("Expect: " +   compare.get(3) + "  :  " +  test.get(3));
        System.out.println("Expect: " +   compare.contains(1) + "  :  " +   test.contains(1));
        System.out.println("Expect: " +   compare.contains(2) + "  :  " +   test.contains(2));
        System.out.println("Expect: " +   compare.isEmpty() + "  :  " +   test.isEmpty());
        System.out.println("Expect: " +   compare.isFull() + "  :  " +   test.isFull());
        System.out.println("Expect: " +   compare.size() + "  :  " +   test.size());
    }
}