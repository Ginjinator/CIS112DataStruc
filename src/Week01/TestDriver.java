package Week01;

/**
 * Created by Erik on 9/5/2017.
 */
public class TestDriver {
    public static void main(String [] args){
        PairOfDice obj1 = new PairOfDice(0,0);
        obj1.roll();
        System.out.println(obj1.toString());
    }
}
