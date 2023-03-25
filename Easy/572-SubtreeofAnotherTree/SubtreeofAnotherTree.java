public class SubtreeofAnotherTree {

    /*
    Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

    Example 1:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
    Given tree t:
       4
      / \
     1   2
    Return true, because t has the same structure and node values with a subtree of s.

    Example 2:
    Given tree s:

         3
        / \
       4   5
      / \
     1   2
        /
       0
    Given tree t:
       4
      / \
     1   2
    Return false.

    */

    // Link : https://leetcode.com/problems/subtree-of-another-tree/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(2);

        TreeNode node2 = new TreeNode(4);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(2);

        System.out.println(isSubtree(node, node2));

    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null)
            return false;

        if (isSameTree(s, t))
            return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

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
