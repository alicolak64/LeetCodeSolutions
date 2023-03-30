public class ConvertSortedArraytoBinarySearchTree {

    /*

    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Example 1:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
    -10  5

    Example 2:

    Given the sorted array: [1,3],

    One possible answer is: [3,1], which represents the following height balanced BST:

          3           1
         /             \
        1               3

     */

    // Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/


    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        assert root != null;
        System.out.println(root.val);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);

    }

    public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {

        if(start > end)
            return null;

        int mid = (start + end) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;

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
