public class MinimumDepthofBinaryTree {

    /*

    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7

    return its minimum depth = 2.

    */

    // Link : https://leetcode.com/problems/minimum-depth-of-binary-tree/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(minDepth(root));

    }

    public static int minDepth(TreeNode root) {

        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return 1;

        if(root.left == null)
            return minDepth(root.right) + 1;

        if(root.right == null)
            return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

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
