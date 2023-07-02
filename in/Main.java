package in.ineuron.in;

//Node class to represent a node in the binary tree
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Binary Tree class
class BinaryTree {
 Node root;

 // Recursive function to print the left view of the binary tree
 void printLeftView() {
     printLeftViewUtil(root, 1);
 }

 // Utility function to recursively print the left view of the binary tree
 void printLeftViewUtil(Node node, int level) {
     if (node == null)
         return;
    int maxLevel=0;
     // If this is the first node at the current level, print it
     if (level > maxLevel) {
         System.out.print(node.data + " ");
         maxLevel = level;
     }

     // Recur for the left and right subtrees
     printLeftViewUtil(node.left, level + 1);
     printLeftViewUtil(node.right, level + 1);
 }
}

public class Main {
 public static void main(String[] args) {
     // Create a binary tree
     BinaryTree tree = new BinaryTree();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.left.right = new Node(5);
     tree.root.left.left.right.right = new Node(6);

     // Print the left view of the binary tree
     tree.printLeftView();
 }
}
