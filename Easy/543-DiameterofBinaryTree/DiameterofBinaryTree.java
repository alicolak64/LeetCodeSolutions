public class DiameterofBinaryTree {

    /*
    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    Example:
    Given a binary tree
              1
             / \
            2   3
           / \
          4   5
    Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

    Note: The length of path between two nodes is represented by the number of edges between them.

    */

    // Link : https://leetcode.com/problems/diameter-of-binary-tree/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(node));

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(left, Math.max(right, leftHeight + rightHeight));

    }

    public static int height(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));

    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

}
