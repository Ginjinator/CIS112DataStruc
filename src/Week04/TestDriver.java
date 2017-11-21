package Week04;

import java.util.Scanner;
/**
 * Created by Erik on 9/30/2017.
 */

public class TestDriver {
    public static void main(String[] args) {
        OnlineAuction stack = new OnlineAuction();
        CreateBidder bidder = new CreateBidder("", 1, 1);
        Scanner kb = new Scanner(System.in);

        do {
            System.out.println("Enter the next bidders name: ");
            bidder.setName(kb.nextLine());
            if (bidder.getName() == "quit") {
                System.out.println("Ending.");
                break;
            } else {
                System.out.println("Enter their high bid: ");
                bidder.setHighBid(kb.nextInt());
                System.out.println("Enter their max bid: ");
                bidder.setMaxBid(kb.nextInt());
            }
            stack.setStack(bidder);
        } while (true);
        System.out.println(stack.toString());
    }
}