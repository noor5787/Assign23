package in.ineuron.in;
class BinaryTreeDepth {
    static int calculateDepth(String preorder) {
        int depth = 0;
        int maxDepth = 0;
        
        for (char c : preorder.toCharArray()) {
            if (c == 'n') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == 'l') {
                depth--;
            }
        }
        
        return maxDepth;
    }
    
    public static void main(String[] args) {
        String preorder1 = "nlnll";
        int depth1 = calculateDepth(preorder1);
        System.out.println("Depth 1: " + depth1); // Output: 2
        
        String preorder2 = "nlnnlll";
        int depth2 = calculateDepth(preorder2);
        System.out.println("Depth 2: " + depth2); // Output: 3
    }
}
