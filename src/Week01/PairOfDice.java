package Week01;

/**
 * Created by Erik on 9/5/2017.
 */
public class PairOfDice{
    private int dice1;
    private int dice2;
    private int total;

    public PairOfDice(int die1, int die2){
        this.dice1 = die1;
        this.dice2 = die2;
    }

    public void roll(){
        dice1 = (int)(Math.random()*6 + 1);
        dice2 = (int)(Math.random()*6 + 1);
    }

    public int getTotal(){return total = dice1 + dice2;}

    public int getDice1(){
        return dice1;
    }

    public int getDice2(){
        return dice2;
    }


    @Override
    public String toString(){
        return "Dice 1: " + getDice1() + "\nDice 2: " + getDice2() + "\nTotal: " + getTotal();
    }
}
