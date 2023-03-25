public class ConstructBinaryTreefromPreorderandInorderTraversal {

    /*
    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given

    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:

        3
       / \
      9  20
        /  \
       15   7
    */

    // Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    public static void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode node = buildTree(preorder, inorder);

        System.out.println(node);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode node = new TreeNode(preorder[preStart]);

        int index = 0;

        for (int i = inStart; i <= inEnd; i++) {

            if (inorder[i] == preorder[preStart]) {

                index = i;
                break;

            }

        }

        node.left = buildTree(preorder, inorder, preStart + 1, preStart + index - inStart, inStart, index - 1);
        node.right = buildTree(preorder, inorder, preStart + index - inStart + 1, preEnd, index + 1, inEnd);

        return node;

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
