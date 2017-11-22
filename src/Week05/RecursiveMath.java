package Week05;

import java.util.Scanner;

public class RecursiveMath{
   
   public static void main(String[] args){
      Scanner kb = new Scanner(System.in);
      int num = 0;
      
      System.out.print("Enter a nonnegative number larger than zero: ");
      num = kb.nextInt();
      System.out.println();
      
      System.out.println("Sum(N): " + sum(num));
      System.out.println("BiPower(N): " + biPower(num));
      System.out.println("TimesFive(N): " + timesFive(num));
   }
   
   public static int sum(int n){
      if(n == 1){
         return 1;
      }
      else{
         return (n + sum(n-1));
      }
   }
   
   public static int biPower(int n){
     /* int value = 2;
      while(n!=1){
         value = value * 2;
         n--;
      }
      return value;*/
      
      //recursive
      if(n == 0)
         return 1;
      else
         return (2 * biPower(n-1));
   }
   
   public static int timesFive(int n){
      if (n == 0)
         return 0;
      else
         return (5 + timesFive(n - 1));
   }
}