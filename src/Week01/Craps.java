package Week01;

/**
 * Created by Erik on 9/5/2017.
 */
public class Craps {
    private static PairOfDice game = new PairOfDice(0,0);
    private static int comeOut;
    private static int point;
    private static double winCount;
    private static double lossCount;
    private static double totalCount;
    private static double winPercent;

    public static void play(){
        for(int i = 1; i <= 100000; i++){
            game.roll();
            comeOut = game.getTotal();
                point = 0;
            if(comeOut  == 2 || comeOut == 3 || comeOut == 12){
                lossCount++;
            } else if (comeOut == 7 || comeOut == 11) {
                winCount++;
            } else{
                point += comeOut;
                comeOut = 0;
                while(comeOut != point || comeOut != 7) {
                    game.roll();
                    if (game.getTotal() == point){
                        winCount++;
                        break;
                    }
                    if (game.getTotal() == 7){
                        lossCount++;
                        break;
                    }
                }
            }
        }
    }

    public static double getWinPercent(){
        totalCount = winCount + lossCount;
        return winPercent = ((winCount/totalCount) * 100);
    }

    public static void main(String [] args){
        play();
        System.out.println("Wins: " + winCount + "\nLosses: " + lossCount + "\nWin Percent: " + getWinPercent());
    }
}