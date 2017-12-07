/*
This class will make the extras to add to a person:
Address
Email, Website
Phone Number
*/
package Week15Final.NameGenerator;

public class ExtrasGenerator {
    public String address;
    public String email;
    public String website;
    public String phoneNumber;

    //Create a random number and combine it with an address from the list
    public String addressGenerator(){
        return address;
    }

    //Take first and last name, combine them, add random number
    //Concatenate with domain i.e. gmail, yahoo, aol
    public String emailGenerator(){
        return email;
    }

    //Generate 10 random number and put them into phone number order
    public String  phoneNumberGenerator(){
        return phoneNumber;
    }
}