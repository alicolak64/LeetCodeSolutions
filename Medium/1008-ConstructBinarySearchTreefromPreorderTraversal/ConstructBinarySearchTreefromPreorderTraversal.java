public class ConstructBinarySearchTreefromPreorderTraversal {

    /*

    Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

    It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

    A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

    A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

    Example 1:

    Input: preorder = [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

    Example 2:

    Input: preorder = [1,3]
    Output: [1,null,3]

    */

    // Link : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode node = bstFromPreorder(preorder);

        System.out.println(node);

    }

    public static TreeNode bstFromPreorder(int[] preorder) {

        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {

            TreeNode node = root;

            while (true) {

                if (preorder[i] < node.val) {

                    if (node.left == null) {

                        node.left = new TreeNode(preorder[i]);
                        break;

                    } else {

                        node = node.left;

                    }

                } else {

                    if (node.right == null) {

                        node.right = new TreeNode(preorder[i]);
                        break;

                    } else {

                        node = node.right;

                    }

                }

            }

        }

        return root;

    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

}
