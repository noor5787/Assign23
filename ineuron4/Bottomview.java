package in.ineuron4;
import java.util.*;

class Node {
    int data;
    int hd;
    Node left, right;

    public Node(int data) {
        this.data = data;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

class BottomView {
    Node root;

    public BottomView() {
        root = null;
    }

    public void printBottomView() {
        if (root == null) {
            return;
        }

        int hd = 0;

        // Map to store the horizontal distance and the bottom-most node for that distance
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue to perform level order traversal
        Queue<Node> queue = new LinkedList<>();
        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            hd = node.hd;

            // Update the horizontal distance and the bottom-most node in the map
            map.put(hd, node.data);

            if (node.left != null) {
                node.left.hd = hd - 1;
                queue.add(node.left);
            }

            if (node.right != null) {
                node.right.hd = hd + 1;
                queue.add(node.right);
            }
        }

        // Print the bottom view nodes
        for (int value : map.values()) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        BottomView tree = new BottomView();

        // Constructing the binary tree
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(25);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        System.out.println("Bottom View: ");
        tree.printBottomView();
    }
}
