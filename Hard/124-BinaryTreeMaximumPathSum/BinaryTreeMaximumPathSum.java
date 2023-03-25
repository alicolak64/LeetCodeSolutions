public class BinaryTreeMaximumPathSum {

    /*
    Given a non-empty binary tree, find the maximum path sum.

    For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

    Example 1:

    Input: [1,2,3]

           1
          / \
         2   3

    Output: 6
    Example 2:

    Input: [-10,9,20,null,null,15,7]

       -10
       / \
      9  20
        /  \
       15   7

    Output: 42
    */

    // Link : https://leetcode.com/problems/binary-tree-maximum-path-sum/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        System.out.println(maxPathSum(node));

    }

    public static int maxPathSum(TreeNode root) {

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];

    }

    public static int maxPathSum(TreeNode root, int[] max) {

        if (root == null)
            return 0;

        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));

        max[0] = Math.max(max[0], left + right + root.val);

        return Math.max(left, right) + root.val;

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
