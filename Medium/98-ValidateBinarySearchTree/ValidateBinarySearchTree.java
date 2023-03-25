public class ValidateBinarySearchTree {

    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Example 1:

        2
       / \
      1   3

    Input: [2,1,3]
    Output: true

    Example 2:

        5
       / \
      1   4
         / \
        3   6

    Input: [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.

    */

    // Link : https://leetcode.com/problems/validate-binary-search-tree/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(6);

        System.out.println(isValidBST(node));

    }

    public static boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);

    }

    public static boolean isValidBST(TreeNode root, Integer min, Integer max) {

        if (root == null)
            return true;

        if (min != null && root.val <= min)
            return false;

        if (max != null && root.val >= max)
            return false;

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

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
