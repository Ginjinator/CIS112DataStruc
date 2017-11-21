package Week09;

import support.BSTNode;
import ch04.queues.*;
import ch07.trees.BinarySearchTree;

public class BSTHomework<T> extends BinarySearchTree<T>{

    //recursive solution to height
    private int recursiveHeight(BSTNode<T> node){
        if(node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        if(node.getLeft() == null) {
            return recursiveHeight(node.getRight()) + 1;
        }
        if(node.getRight() == null) {
            return recursiveHeight(node.getLeft()) + 1;
        }
        return largerSide(recursiveHeight(node.getRight()), recursiveHeight(node.getLeft())) + 1;
    }

    //used in the driver class to use the above method
    public int getRecursiveHeight(){
        return recursiveHeight(root);
    }

    //find the larger side for the above method
    public static int largerSide(int a, int b){
        if(a > b)return a;
        return b;
    }

    //iterative way to find the height
    public int iterativeHeight(){
        LinkedQueue<BSTNode<T>> queue = new LinkedQueue<BSTNode<T>>();
        int height = 0;
        if(root!=null)queue.enqueue(root);
        while(!queue.isEmpty()){
            height++;
            LinkedQueue<BSTNode<T>> newQueue = new LinkedQueue<BSTNode<T>>();
            while(!queue.isEmpty()){
                BSTNode<T> parent = queue.dequeue();
                if(parent.getRight() != null)
                    newQueue.enqueue(parent.getRight());
                if(parent.getLeft() != null)
                    newQueue.enqueue(parent.getLeft());
            }
            queue = newQueue;
        }
        return height;
    }

    public double fullnessRatio(){
        return (double)minHeight()/getRecursiveHeight();
    }

    public int minHeight(){
        int height = 0;
        int capacity = 0;
        while(size() > capacity){
            capacity += Math.pow(2, height);
            height++;
        }
        return height;
    }
}