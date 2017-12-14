/**
Take names from the list of first and last names files
and combine them to make one full name
*/
package Week15Final.NameGenerator;

import java.io.*;
import java.util.ArrayList;

public class NameGenerator {

    protected String firstName;
    protected String lastName;
    protected ArrayList<String> firstNames = new ArrayList<>();
    protected ArrayList<String> lastNames = new ArrayList<>();

    public void readFirstNames() throws IOException{
        try {
            FileInputStream newStream = new FileInputStream("C:\\Users\\Erik\\Documents\\School\\Comp Sci" +
                    "\\CIS112\\FirstNames.txt");
            DataInputStream inStream = new DataInputStream(newStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while((line = reader.readLine()) != null ){
                firstNames.add(line);
            }
            //This will set the first name
            firstName = firstNames.get((int)(Math.random() * (5494)));
            inStream.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    //get a new first name from the list
    public void setFirstName(){
        firstName = firstNames.get((int)(Math.random() * (5493)));
    }

    //this will return the current first name without getting a new one
    //used for the email
    public String getFirstName(){
        return firstName;
    }

    public void readLastNames() throws IOException{
        try {
            FileInputStream newStream = new FileInputStream("C:\\Users\\Erik\\Documents\\School\\Comp Sci" +
                    "\\CIS112\\LastNames.txt");
            DataInputStream inStream = new DataInputStream(newStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while((line = reader.readLine()) != null ){
                lastNames.add(line);
            }
            //set the first lastName
            lastName = lastNames.get((int)(Math.random() * (4450)));
            inStream.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    //get a new last name
    public void setLastName(){
        lastName = lastNames.get((int)(Math.random() * (4450)));
    }

    //return the current last name
    public String getLastName(){
        return lastName;
    }
}