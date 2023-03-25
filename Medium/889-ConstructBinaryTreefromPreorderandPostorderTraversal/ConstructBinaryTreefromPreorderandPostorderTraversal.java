public class ConstructBinaryTreefromPreorderandPostorderTraversal {

    /*
    Return any binary tree that matches the given preorder and postorder traversals.

    Values in the traversals pre and post are distinct positive integers.

    Example 1:

    Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
    Output: [1,2,3,4,5,6,7]

    Note:

    1 <= pre.length == post.length <= 30
    pre[] and post[] are both permutations of 1, 2, ..., pre.length.
    It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
    */

    // Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

    public static void main(String[] args) {

        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};

        TreeNode node = constructFromPrePost(pre, post);

        System.out.println(node);

    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {

        return constructFromPrePost(pre, post, 0, pre.length - 1, 0, post.length - 1);

    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd) {

        if (preStart > preEnd || postStart > postEnd)
            return null;

        TreeNode node = new TreeNode(pre[preStart]);

        if (preStart == preEnd)
            return node;

        int index = 0;

        for (int i = postStart; i <= postEnd; i++) {

            if (post[i] == pre[preStart + 1]) {

                index = i;
                break;

            }

        }

        node.left = constructFromPrePost(pre, post, preStart + 1, preStart + 1 + index - postStart, postStart, index);
        node.right = constructFromPrePost(pre, post, preStart + 1 + index - postStart + 1, preEnd, index + 1, postEnd - 1);

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
