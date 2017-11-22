package Week05;

import support.LLNode;

public class Evens{
   
   public static int numEvens(LLNode<Integer> list){
      if(list.getInfo() % 2 == 0 && list.getLink() != null){
         return 1 + numEvens(list.getLink());
      }
      else if(list.getInfo() % 2 == 1 && list.getLink() != null){
         return numEvens(list.getLink());
      }
      else if(list.getInfo() % 2 == 0)
         return 1;
      else
         return 0;
   }

   public static boolean contains(int n, LLNode<Integer> list){
      if (list.getInfo() == n)
         return true;
      else if (list.getLink() != null)
         return contains(n, list.getLink());
      else
         return false;
   }
   public static void main(String[] args){

      LLNode<Integer> first = new LLNode(3);
      LLNode<Integer> second = new LLNode(2);
      LLNode<Integer> third = new LLNode(2);
      LLNode<Integer> fourth = new LLNode(4);
      LLNode<Integer> fifth = new LLNode(6);
      LLNode<Integer> sixth = new LLNode(9);

      first.setLink(second);
      second.setLink(third);
      third.setLink(fourth);
      fourth.setLink(fifth);
      fifth.setLink(sixth);

      System.out.println(numEvens(first));
      System.out.println(contains(8, first));
   }
}