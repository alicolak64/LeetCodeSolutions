public class KthSmallestElementinaBST {

    /*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

    Example 1:

    Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
    Output: 1

    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
    Output: 3

    Follow up:
    What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

    Constraints:

    The number of elements of the BST is between 1 to 10^4.
    You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

    */

    // Link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.left.right = new TreeNode(2);

        System.out.println(kthSmallest(node, 1));

    }

    public static int kthSmallest(TreeNode root, int k) {

        int[] result = new int[2];
        kthSmallest(root, k, result);
        return result[1];

    }

    public static void kthSmallest(TreeNode root, int k, int[] result) {

        if (root == null)
            return;

        kthSmallest(root.left, k, result);

        if (++result[0] == k) {
            result[1] = root.val;
            return;
        }

        kthSmallest(root.right, k, result);

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
