/**
 * Creates an object of type person containing:
 * business name
 * last and first name
 * extras (address, phone and email)
 *
 * Current problem: outputs same name for multiple objects
 * Possible solution: change getName methods
 *                    make array or list of strings instead of objects
 */

package Week15Final.MakeAndSort;

import Week15Final.NameGenerator.BusinessNameGenerator;
import Week15Final.NameGenerator.ExtrasGenerator;
import Week15Final.NameGenerator.NameGenerator;

//final sort\database method will be a binary search tree of _________ in order to be able to search
//binary search tree will be organized based on either last name or business name

public class CreatePerson<T>{

    protected String busName;
    protected String personName;
    protected String personExtras;

    NameGenerator name = new NameGenerator();
    BusinessNameGenerator business = new BusinessNameGenerator();
    ExtrasGenerator extras = new ExtrasGenerator();

    public CreatePerson(){
        busName = null;
        personName = null;
        personExtras = null;
    }

    public CreatePerson(String business, String last, String first,  String address, String phone, String email){
        busName = business;
        personName = last + ", " + first;
        personExtras = address + "\n" + phone + "\n" + email;
    }

    public void setBusName(String business){
        busName = business;
    }

    public String getBusName() {
        return busName;
    }

    public void setPersonName(String last, String first){
        personName = last + ", " + first;
    }

    public String getPersonName(){
        return personName;
    }

    public void setPersonExtras(String address, String phone, String email){
        personExtras = address + "\n" + phone + "\n" + email;
    }

    public String getPersonExtras(){
        return personExtras;
    }

    public String toString(){
        return busName.toUpperCase() + "\n" + personName + "\n" + personExtras.toUpperCase();
    }
}