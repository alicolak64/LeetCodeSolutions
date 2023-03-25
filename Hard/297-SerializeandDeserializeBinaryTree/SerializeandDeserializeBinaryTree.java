public class SerializeandDeserializeBinaryTree {

    /*
    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

    Example:

    You may serialize the following tree:

        1
       / \
      2   3
         / \
        4   5

    as "[1,2,3,null,null,4,5]"
    Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

    Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
    */

    // Link : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(5);

        System.out.println(serialize(node));

    }

    public static String serialize(TreeNode root) {

        if (root == null)
            return "null";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);

    }

    public static TreeNode deserialize(String data) {

        String[] nodes = data.split(",");
        return deserialize(nodes, new int[]{0});

    }

    public static TreeNode deserialize(String[] nodes, int[] index) {

        if (nodes[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        node.left = deserialize(nodes, index);
        node.right = deserialize(nodes, index);

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
