package Week15Final.MakeAndSort;

import Week15Final.NameGenerator.BusinessNameGenerator;
import Week15Final.NameGenerator.ExtrasGenerator;
import Week15Final.NameGenerator.NameGenerator;

//final sort\database method will be a binary search tree of _________ in order to be able to search
//binary search tree will be organized based on either last name or business name

public class CreatePerson<T>{

    NameGenerator name = new NameGenerator();
    BusinessNameGenerator business = new BusinessNameGenerator();
    ExtrasGenerator email = new ExtrasGenerator();
    ExtrasGenerator address = new ExtrasGenerator();
    ExtrasGenerator phone = new ExtrasGenerator();


}