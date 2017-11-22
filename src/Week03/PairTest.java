package Week03;

/**
 * Created by Erik on 9/20/2017.
 */
public class PairTest {
    public static void main(String[] args){
        PairInterface myPair = new ArrayPair<String>("ape", "monkey");
        System.out.print(myPair.getFirst() + " ");
        myPair.setSecond("doggo");
        System.out.println(myPair.getSecond());
    }
}
