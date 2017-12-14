// whats left to do
// 1.make one sortable object/list with information created
// 2.make the sort and search algorithm/method

package Week15Final.CommandLine;

import Week15Final.MakeAndSort.*;
import Week15Final.NameGenerator.*;

import java.util.Comparator;
import java.io.IOException;

public class FinalDriver {

    public static CreatePerson [] people = new CreatePerson[10000];

    public static void main(String[] args) throws IOException {

        Comparator<CreatePerson> businessName = Comparator.comparing(CreatePerson::getBusName);
        Comparator<CreatePerson> lastName = Comparator.comparing(CreatePerson::getPersonName);

        BinarySearchTree<CreatePerson> businessNames = new BinarySearchTree(businessName);
        BinarySearchTree<CreatePerson> lastNames = new BinarySearchTree(lastName);

        BusinessNameGenerator business = new BusinessNameGenerator();
        business.readFile();

        NameGenerator name = new NameGenerator();
        name.readFirstNames();
        name.readLastNames();

        ExtrasGenerator extras = new ExtrasGenerator();
        extras.readAddresses();

        for (int i = 0; i < 10000 ; i++) {
            CreatePerson<String> person = new CreatePerson<>(business.getRandomName(), name.getLastName(),
                    name.getFirstName(), extras.getAddress(), extras.getPhoneNumber(),
                    extras.makeEmail(name.getFirstName(), name.getLastName()));

            people[i] = person;
            name.setLastName();
            name.setFirstName();
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
            System.out.println();
        }
    }
}