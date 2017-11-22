package Week02;
/*
 * Erik Ellis
 * Chapter 1
 * ArrayPractice
 */
import java.util.Random;
import java.util.Scanner;

public class ArraySkills {

    public static void main(String[] args) {

        // ***********************
        // For each item below you must code the solution. You may not use any of the
        //  methods found in the Arrays class or the Collections classes
        //
        String[] myData;
        String temp = null;
        Random ran = new Random(10);
        // 1. Instantiate the given array to hold 10 Strings.
        myData = new String[10];
        // 2. Add your name to the Array at index 0 and a friend's name to the Array at index 4
        myData[0] = "Erik Ellis";
        myData[4] = "Steven Taylor";
        // 3. Move your friend's name to index 0 in the array and "delete" their name from index 4
        myData[5] = myData[4];
        myData[4] = "";
        // 4. Fill up all of the remaining indeces in the array with more names
        myData[1] = "Tyler";
        myData[2] = "Brandon";
        myData[3] = "Will";
        myData[6] = "Marlena";
        myData[7] = "Megan";
        myData[8] = "Peter";
        myData[9] = "Ted";
        // 5. Swap the values at index 5 and index 1
        temp = myData[5];
        myData[5] = myData[1];
        myData[1] = temp;
        // 6. Print the array from beginning to end.
        for(int x = 0; x <= myData.length - 1; x++)
            System.out.println(myData[x]);
        // 7. Shuffle the array of strings
        for(int i = 0; i <= myData.length - 1; i++){
            int rndm = ran.nextInt(10);
            temp = myData[i];
            myData[i] = myData[rndm];
            myData[rndm] = temp;
        }
        // 8. Find and print the longest and shortest Strings in the array
        String largest = myData[0];
        String smallest = myData[0];
        for(int j = 1; j <= myData.length - 1;j++){
            if(myData[j].length() > largest.length()){
                largest = myData[j];
            }
            if(myData[j].length() < smallest.length()){
                smallest = myData[j];
            }
        }
        // 9. Add up the total number of characters in all of the strings in the array and print the answer
        int count = 0;
        for(int h = 0; h <= myData.length - 1; h++){
            count += myData[h].length();
        }
        // 10. Prompt the user for a String and then perform a linear search of the array
        //  to see if that string is or is not in the array. Print if it is or is not found.
        System.out.print("\nEnter a string: ");
        Scanner kb = new Scanner(System.in);
        String lookFor = kb.nextLine();
        boolean found = false;
        for(int l = 0; l <= myData.length - 1; l++){
            if(lookFor.equals(myData[l])){
                System.out.println("Index of input found at index " + l + " (" + myData[l] + ")");
                found = true;
            }
        }
        if(!found)
            System.out.println("That is not in the array");
        // 11. Remove the item at index 4 of the array by shifting everything after it one spot to the left.
        // This means your array should have one empty index at the end after the shift (delete the duplicate item at the end).
        for(int x = 4; x < myData.length - 2; x++){
            myData[x] = myData[x + 1];
        }
        myData[myData.length - 1] = "";
        // 12. Create a new array that is twice as big as the current array and copy all of the items to the new array.
        // When complete, swap references so our old array gets garbage collected and the new array is pointed to by your array variable myData.
        String [] newMyData = new String[myData.length * 2];
        for(int i = 0; i < myData.length; i++){
            newMyData[i] = myData[i];
        }
        myData = newMyData;
        // 13. Prompt the user to enter 2 numbers within the range of the array's length. If the first is larger than the second print backwards from that index to the first.
        // If the second is larger than the first, print forward in the array from the first index to the second.
        System.out.println("Enter a number between 0 and " + newMyData.length);
        int first = kb.nextInt();
        System.out.println("Enter a number between 0 and " + newMyData.length);
        int second = kb.nextInt();
        if(first > second){
            for(int i = first; i <= second; i++)
                System.out.println(newMyData[i]);
        }
        if(first < second){
            for(int i = second; i >= first; i--)
                System.out.println(newMyData[i]);
        }
        else{
            System.out.println(newMyData[first]);
        }
    }
}