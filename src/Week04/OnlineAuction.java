package Week04;

import ch02.stacks.LinkedStack;
import support.LLNode;

/**
 * Created by Erik on 9/29/2017.
 */

public class OnlineAuction extends LinkedStack{

    //compare current high, to max, if max is larger, compare both maxes, put the larger of the two on the stack
    public void setStack(CreateBidder bidder1, CreateBidder bidder2) {
        LLNode currBid = new LLNode(bidder1.getHighBid());
        int max1 = bidder1.getMaxBid();
        LLNode nextBid = new LLNode(bidder2.getHighBid());
        int max2 = bidder2.getMaxBid();
        if (max1 < max2) {
           nextBid.setInfo(bidder1.getHighBid() + 1);
           currBid.setInfo(nextBid.getInfo());
           currBid.setLink(top);
           bidder1.setHighBid((int)currBid.getInfo());
        }
        else if(max1 > max2){
           currBid.setInfo(bidder2.getMaxBid() + 1);
           bidder1.setHighBid((int)currBid.getInfo());
        }
    }

    public void setStack(CreateBidder newBidder){
        LLNode current = new LLNode(top);
        LLNode newBid = new LLNode(newBidder.getMaxBid());
        int max1 = 0;
        int max2 = (int) newBid.getInfo();
        if(current.getInfo() == null) {
            max1 = 0;
        }else {
            max1 = (int) current.getInfo();
        }
        if (max2 > max1){
            newBid.setInfo(max1 + 1);
            current.setInfo(newBid.getInfo());
            current.setLink(top);
        }
    }
}