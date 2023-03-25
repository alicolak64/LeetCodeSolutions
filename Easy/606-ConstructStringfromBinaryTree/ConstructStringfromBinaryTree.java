public class ConstructStringfromBinaryTree {

    /*

    Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.

    Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.

    Example 1:

    Input: root = [1,2,3,4]
    Output: "1(2(4))(3)"
    Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to omit all the unnecessary empty parenthesis pairs.

    Example 2:

    Input: root = [1,2,3,null,4]
    Output: "1(2()(4))(3)"
    Explanation: Almost the same as the first example, except we cannot omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.

     */

    // Link : https://leetcode.com/problems/construct-string-from-binary-tree/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        String str = tree2str(root);

        System.out.println(str);

    }

    public static String tree2str(TreeNode root) {

        if (root == null)
            return "";

        if (root.left == null && root.right == null)
            return root.val + "";

        if (root.right == null)
            return root.val + "(" + tree2str(root.left) + ")";

        return root.val + "(" + tree2str(root.left) + ")" + "(" + tree2str(root.right) + ")";

    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

}
