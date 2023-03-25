public class ConstructBinaryTreefromInorderandPostorderTraversal {

    /*
    Given inorder and postorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

    For example, given

    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    Return the following binary tree:

        3
       / \
      9  20
        /  \
       15   7
    */

    // Link : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode node = buildTree(inorder, postorder);

        System.out.println(node);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode node = new TreeNode(postorder[postEnd]);

        int index = 0;

        for (int i = inStart; i <= inEnd; i++) {

            if (inorder[i] == postorder[postEnd]) {

                index = i;
                break;

            }

        }

        node.left = buildTree(inorder, postorder, inStart, index - 1, postStart, postStart + index - inStart - 1);
        node.right = buildTree(inorder, postorder, index + 1, inEnd, postStart + index - inStart, postEnd - 1);

        return node;

    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

    }

}
