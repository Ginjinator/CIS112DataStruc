// whats left to do
// 1.make one sortable object/list with information created
// 2.make the sort and search algorithm/method

package Week15Final;

import Week15Final.NameGenerator.BusinessNameGenerator;
import Week15Final.NameGenerator.ExtrasGenerator;
import Week15Final.NameGenerator.NameGenerator;

import java.io.IOException;

public class FinalDriver {

    public static void main(String[] args) throws IOException {
        BusinessNameGenerator business = new BusinessNameGenerator();
        business.readFile();


        NameGenerator name = new NameGenerator();
        name.readFirstNames();
        name.readLastNames();

        ExtrasGenerator extras = new ExtrasGenerator();
        extras.readAddresses();
        for (int i = 0; i < 10000; i++) {
            System.out.println("Person " + i + ":");
            System.out.println(business.getRandomName().toUpperCase());
            System.out.println(name.getLastName() + ", " + name.getFirstName());
            System.out.println(extras.getAddress().toUpperCase());
            System.out.println(extras.getPhoneNumber());
            System.out.println(extras.makeEmail(name.getFirstName(), name.getLastName()).toUpperCase());
            System.out.println();
            name.setFirstName();
            name.setLastName();
        }
    }
}