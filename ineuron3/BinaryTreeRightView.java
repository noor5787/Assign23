package in.ineuron3;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Node class represents a node in the binary tree
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// Main class to print the right view of a binary tree
public class BinaryTreeRightView {
    Node root;

    // Function to print the right view of the binary tree
    void printRightView() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // Add the rightmost node at each level to the list
                if (i == size - 1)
                    levelNodes.add(node.data);

                // Add the left and right children of the current node to the queue
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            // Print the last node (rightmost) at each level
            for (int num : levelNodes)
                System.out.print(num + " ");
        }
    }

    // Test the program with sample inputs
    public static void main(String[] args) {
        BinaryTreeRightView tree = new BinaryTreeRightView();

        // Constructing the binary tree from the example inputs
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(8);

        System.out.print("Right view of the tree is: ");
        tree.printRightView();
    }
}
