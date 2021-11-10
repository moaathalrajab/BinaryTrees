
package com.mycompany.binarytrees_bst;

public class BinarySearchTree {
   private Node root;
   
   public BinarySearchTree() {
      root = null;
   }
   
   public Node getRoot() {
      return root;
   }
   public void setRoot(Node r) {
       root=r;
   }
   
   public Node copyTree(Node root){
      if(root == null) return null;
      Node r = copyTree(root.right);     
      Node l = copyTree(root.left);      
      return (new Node(root.key, l, r));
   }
   
   public void preorderPrint(Node root) {
        if (root == null) return;
        System.out.println(root.key);
        preorderPrint(root.left);
        preorderPrint(root.right);
    }

    public void postorderPrint(Node root) {
        if (root == null) return;
        preorderPrint(root.left);
        preorderPrint(root.right);
        System.out.println(root.key);
    }
        
    public void inorderPrint(Node root) {
        if (root == null)  return;
        preorderPrint(root.left);
        System.out.println(root.key);
        preorderPrint(root.right);
    }
   
   
   public Node search(int desiredKey) {
      Node currentNode = root;
      while (currentNode != null) {
         // Return the node if the key matches
         if (currentNode.key == desiredKey) {
            return currentNode;
         }
         
         // Navigate to the left if the search key is 
         // less than the node's key.
         else if (desiredKey < currentNode.key) {
            currentNode = currentNode.left;
         }
         
         // Navigate to the right if the search key is 
         // greater than the node's key.
         else {
            currentNode = currentNode.right;
         }
      }
      
      // The key was not found in the tree.
      return null;
   }
   
   public void insert(Node node) {
      // Check if tree is empty
      if (root == null) {
         root = node;
      }
      else {
         Node currentNode = root;
         while (currentNode != null) {
            if (node.key < currentNode.key) {
               // If no left child exists, add the new node
               // here; otherwise repeat from the left child.
               if (currentNode.left == null) {
                  currentNode.left = node;
                  currentNode = null;
               }
               else {
                  currentNode = currentNode.left;
               }
            }
            else {
               // If no right child exists, add the new node
               // here; otherwise repeat from the right child.
               if (currentNode.right == null) {
                  currentNode.right = node;
                  currentNode = null;
               }
               else {
                  currentNode = currentNode.right;
               }
            }
         }
      }
   }
   
   public boolean remove(int key) {
      Node parent = null;
      Node currentNode = root;
      
      // Search for the node.
      while (currentNode != null) {
         // Check if currentNode has a matching key.
         if (currentNode.key == key) {
            if (currentNode.left == null && currentNode.right == null) {
               if (parent == null) { // Node is root
                  root = null;
               }
               else if (parent.left == currentNode) { 
                  parent.left = null;
               }
               else {
                  parent.right = null;
               }
               return true; // Node found and removed
            }
            else if (currentNode.left != null && currentNode.right == null) {
               if (parent == null) { // Node is root
                  root = currentNode.left;
               }
               else if (parent.left == currentNode) {
                  parent.left = currentNode.left;
               }
               else {
                  parent.right = currentNode.left;
               }
               return true; // Node found and removed
            }
            else if (currentNode.left == null && currentNode.right != null) {
               if (parent == null) { // Node is root
                  root = currentNode.right;
               }
               else if (parent.left == currentNode) {
                  parent.left = currentNode.right;
               }
               else {
                  parent.right = currentNode.right;
               }
               return true; // Node found and removed
            }
            else {
               // Find successor (leftmost child of right subtree)
               Node successor = currentNode.right;
               while (successor.left != null) {
                  successor = successor.left;
               }
               currentNode.key = successor.key; // Copy successor to current node
               parent = currentNode;
               currentNode = currentNode.right; // Remove successor from right subtree
               key = successor.key;             // Loop continues with new key
            }
         }
         else if (currentNode.key < key) { // Search right
            parent = currentNode;
            currentNode = currentNode.right;
         }
         else { // Search left
            parent = currentNode;
            currentNode = currentNode.left;
         }
      }
      return false; // Node not found
   }
}
