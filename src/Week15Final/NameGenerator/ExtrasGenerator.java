/**
This class will make the extras to add to a person:
Address
Email, Website
Phone Number
*/
package Week15Final.NameGenerator;

import java.io.*;
import java.util.ArrayList;

public class ExtrasGenerator {

    protected String address;
    protected int addressNum;
    protected String email;
    protected String phoneNumber;
    protected ArrayList<String> addresses = new ArrayList<>();

    public void readAddresses() throws IOException{
        try {
            FileInputStream newStream = new FileInputStream("C:\\Users\\Erik\\Documents\\School\\Comp Sci" +
                    "\\CIS112\\AddressList.txt");
            DataInputStream inStream = new DataInputStream(newStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while((line = reader.readLine()) != null ){
                addresses.add(line);
            }
            inStream.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Create a random number and combine it with an address from the list
    public String getAddress() throws IOException{
        addressNum = (int)(Math.random() * 3500);
        address = String.valueOf(addressNum);
        address += " " + addresses.get((int) (Math.random() * 239));
        return address;
    }

    //Take first and last name, combine them, add random number
    //Concatenate with domain i.e. gmail, yahoo, aol
    public String makeEmail(String first, String last){
        //popular domains              0             1            2              3             4            5
        String [] domainNames = {"@gmail.com", "@yahoo.com", "@verizon.net", "@comcast.net", "@aol.com", "@hotmail.com",
                //   6         7              8
                "@live.com", "@msn.com", "@outlook.com"};
        String domain = domainNames[(int)(Math.random() * 9)];

        //if the random number is an even number
        if((Math.random() * 10) % 2 == 0){
            email = first + String.valueOf(addressNum) + last + domain;
        }else{
            email = last + first + String.valueOf(addressNum) + domain;
        }
        return email;
    }

    //Generate 10 random number and put them into phone number order
    private void  phoneNumberGenerator(){
        int firstThree;
        int secondThree;
        int lastFour;
        firstThree = (int)(100 + Math.random() * 899);
        secondThree = (int)(100 + Math.random() * 899);
        lastFour = (int)(1000 + Math.random() * 8999);
        phoneNumber = "(" + firstThree + ")" + secondThree + "-" + lastFour;
    }

    public String getPhoneNumber(){
        phoneNumberGenerator();
        return phoneNumber;
    }
}