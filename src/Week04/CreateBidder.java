package Week04;

/**
 * Created by Erik on 9/29/2017.
 */

public class CreateBidder{
    private String name;
    private int highBid;
    private int maxBid;

    public CreateBidder(String name, int highBid, int maxBid) {
        this.name = name;
        this.highBid = highBid;
        this.maxBid = maxBid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighBid() {
        return highBid;
    }

    public void setHighBid(int highBid) {
        this.highBid = highBid;
    }

    public int getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(int maxBid) {
        this.maxBid = maxBid;
    }

    public String toString(){
        return getName() + getHighBid() + getMaxBid();
    }
}