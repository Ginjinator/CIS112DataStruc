package Week10;

import support.FamousPerson;
import java.io.*;

public class FamousPersonCSReader {
    public static void main(String[] args) {
        int [] hashValue = new int[23];

        //Obviously this line here will vary for each computer
        File file = new File("C:\\Users\\Erik\\Documents\\School\\Comp Sci\\bookFiles\\bookFiles\\input\\FamousCS.txt");

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            int i = 0;
            while ((line = reader.readLine()) != null){
                int firstComma = line.indexOf(",");
                line = line.replaceFirst(",", "-");

                int secondComma = line.indexOf(",");
                line = line.replaceFirst(",", "-");

                int thirdComma = line.indexOf(",");
                line = line.replaceFirst(",", "-");

                String lastName = line.substring(0,firstComma);
                String firstName = line.substring(firstComma + 1, secondComma);
                int year = Integer.parseInt(line.substring(secondComma + 1, thirdComma));
                String fact = line.substring(thirdComma + 1, line.length());

                hashValue[i] = (new FamousPersonHW(lastName, firstName, year, fact).hashCode());
                i++;
            }
        }
        catch(IOException e){
            System.out.println("Word machine broke");
        }

        for (int j = 1; j < hashValue.length; j++) {
            int key =  hashValue[j];
            int i = j-1;
            while ((i > -1) && ((hashValue[i] -key) > 0)){
                hashValue[i + 1] = hashValue[i];
                i--;
            }
            hashValue[i + 1] = key;
        }

        //Part a and b--------------------------------------------------------------------------//
        for (int i = 0; i < hashValue.length; i++) {
            System.out.println(hashValue[i]);
            hashValue[i] %= 1000;
        }
        System.out.println();

        for (int j = 1; j < hashValue.length; j++) {
            int key = hashValue[j];
            int i = j - 1;
            while ((i > -1) && ((hashValue[i] - key) > 0)) {
                hashValue[i + 1] = hashValue[i];
                i--;
            }
            hashValue[i + 1] = key;
        }

        for (int i = 0; i < hashValue.length; i++) {
            System.out.println(hashValue[i]);
            hashValue[i] %= 100;
        }
        System.out.println();

        for (int j = 1; j < hashValue.length; j++) {
            int key = hashValue[j];
            int i = j - 1;
            while ((i > -1) && ((hashValue[i] - key) > 0)) {
                hashValue[i + 1] = hashValue[i];
                i--;
            }
            hashValue[i + 1] = key;
        }

        //Part c and d-------------------------------------------------------------------------------//
        for (int i = 0; i < hashValue.length; i++) {
            System.out.println(hashValue[i]);
            hashValue[i] %= 10;
        }
        System.out.println();

        for (int j = 1; j < hashValue.length; j++) {
            int key = hashValue[j];
            int i = j - 1;
            while ((i > -1) && ((hashValue[i] - key) > 0)) {
                hashValue[i + 1] = hashValue[i];
                i--;
            }
            hashValue[i + 1] = key;
        }

        for (int i = 0; i < hashValue.length; i++) {
            System.out.println(hashValue[i]);
        }
    }
}