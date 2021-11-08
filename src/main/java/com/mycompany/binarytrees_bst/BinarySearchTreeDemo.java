package com.mycompany.binarytrees_bst;

import java.util.Scanner;

public class BinarySearchTreeDemo {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      BinarySearchTree tree = new BinarySearchTree();
      
      // Ask user for values to insert
      System.out.print("Enter values to insert with spaces between: ");
      String userValues = scnr.nextLine();
      System.out.println();
      
      // Add each value to the tree
      for (String value : userValues.split(" ")) {
          
         try{
          int key = Integer.parseInt(value);
          tree.insert(new Node(key));
         }catch(NumberFormatException e){}
         
      }
      
      // Show the tree
      System.out.println("Initial tree:");
      System.out.println(BSTPrint.treeToString(tree.getRoot()));
      System.out.println();
      
      // Ask the user for a value to remove
      System.out.print("Enter value to remove: ");
      String removeValueString = scnr.nextLine();
      int removeValue = Integer.parseInt(removeValueString);
      System.out.println();
      
      System.out.printf("Tree after removing %d:%n", removeValue);
      tree.remove(removeValue);
      System.out.println(BSTPrint.treeToString(tree.getRoot()));
   }
}
