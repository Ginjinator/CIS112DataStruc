package Week10;

import support.FamousPerson;

public class FamousPersonHW extends FamousPerson{
    public FamousPersonHW(String first, String last, int yearOfBirth, String  fact){
        super(first,last,yearOfBirth,fact);
    }

    @Override
    public int hashCode(){
        return Math.abs((lastName.hashCode() * 3) + firstName.hashCode());
    }
}
