/**
 This class will read a business name from the list
 and turn it into a readable and usable string
 */
package Week15Final.NameGenerator;

import java.io.*;
import java.util.ArrayList;

public class BusinessNameGenerator {

    protected String randomName;
    protected int randomNumber;
    protected ArrayList<String> businessNames = new ArrayList<>();

    //create a random number within the range of the amount of names
    //not in use as of now
    private void randomNumber(){
        randomNumber = (int)(Math.random() * (1145));
    }

    //collect the random number
    //not in use as of now
    public int getRandomNumber(){
        randomNumber();
        return randomNumber;
    }

    //Reads a random line in the file and puts it into a string
    public void readFile() throws IOException{
        try {
            FileInputStream newStream = new FileInputStream("C:\\Users\\Erik\\Documents\\School\\Comp Sci" +
                    "\\CIS112\\BusinessNames.txt");
            DataInputStream inStream = new DataInputStream(newStream);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            String line;
            while((line = reader.readLine()) != null ){
                businessNames.add(line);
            }
            inStream.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Only have to use this method to get random name
    public String getRandomName() throws IOException{
        randomName = businessNames.get((int)(Math.random() * (1145)));
        return randomName;
    }
}