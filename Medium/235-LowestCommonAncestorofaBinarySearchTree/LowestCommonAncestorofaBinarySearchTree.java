public class LowestCommonAncestorofaBinarySearchTree {

    /*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

    Example 1:

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    Output: 6
    Explanation: The LCA of nodes 2 and 8 is 6.
    Example 2:

    Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
    Output: 2
    Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

    Note:

    All of the nodes' values will be unique.
    p and q are different and both values will exist in the BST.

    */

    // Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);

        System.out.println(lowestCommonAncestor(node, new TreeNode(2), new TreeNode(8)));

    }


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null)
            return null;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;

    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }





}
