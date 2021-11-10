
package com.mycompany.binarytrees_bst;


public class Node {
   public int key;
   public Node left;
   public Node right;

   public Node(int nodeKey) {
      key = nodeKey;
      left = null;
      right = null;
   }
   public Node(int nodeKey, Node l, Node r) {
      key = nodeKey;
      left = l;
      right = r;
   }
}