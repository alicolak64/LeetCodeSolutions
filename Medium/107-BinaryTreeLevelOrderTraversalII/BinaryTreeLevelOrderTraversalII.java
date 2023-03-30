import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    /*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
    */

    // Link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(root));

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        List list = new ArrayList();

        if(root == null)
            return list;

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            List<Integer> level = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();

            for(TreeNode node : queue){

                level.add(node.val);

                if(node.left != null)
                    temp.add(node.left);

                if(node.right != null)
                    temp.add(node.right);

            }

            list.add(0, level);
            queue = temp;

        }

        return list;

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



}
