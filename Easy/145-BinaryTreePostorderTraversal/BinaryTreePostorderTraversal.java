import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    /*

    Given a binary tree, return the postorder traversal of its nodes' values.

    Example:

    Input: [1,null,2,3]
       1
        \
         2
        /
       3

    Output: [3,2,1]

    Follow up: Recursive solution is trivial, could you do it iteratively?

    */

    // Link : https://leetcode.com/problems/binary-tree-postorder-traversal/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(postorderTraversal(root));

    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode node = stack.pop();
            list.add(0, node.val);

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);

        }

        return list;

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
