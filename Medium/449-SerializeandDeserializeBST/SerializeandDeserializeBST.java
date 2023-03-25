public class SerializeandDeserializeBST {

    /*
    Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

    The encoded string should be as compact as possible.

    Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
    */

    // Link : https://leetcode.com/problems/serialize-and-deserialize-bst/

    public static void main(String[] args) {

        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(3);

        String serialized = serialize(node);
        System.out.println(serialized);

        TreeNode deserialized = deserialize(serialized);
        System.out.println(deserialized);

    }

    public static String serialize(TreeNode root) {

        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();

    }

    public static void serialize(TreeNode root, StringBuilder sb) {

        if (root == null)
            return;

        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    public static TreeNode deserialize(String data) {

        if (data == null || data.length() == 0)
            return null;

        String[] nodes = data.split(",");
        return deserialize(nodes, 0, nodes.length - 1);

    }

    public static TreeNode deserialize(String[] nodes, int start, int end) {

        if (start > end)
            return null;

        TreeNode node = new TreeNode(Integer.parseInt(nodes[start]));

        int index = start + 1;

        while (index <= end && Integer.parseInt(nodes[index]) < node.val)
            index++;

        node.left = deserialize(nodes, start + 1, index - 1);
        node.right = deserialize(nodes, index, end);

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
