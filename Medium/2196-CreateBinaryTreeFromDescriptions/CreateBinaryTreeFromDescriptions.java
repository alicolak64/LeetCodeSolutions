import java.util.*;

public class CreateBinaryTreeFromDescriptions {

    /*

    You are given a 2D integer array descriptions where descriptions[i] = [parent i, child i, isLeft i] indicates that parent i is the parent of child i in a binary tree of unique values. Furthermore,

    If is Left i == 1, then child i is the left child of parent i.
    If is Left i == 0, then child i is the right child of parent i.
    Construct the binary tree described by descriptions and return its root.

    The test cases will be generated such that the binary tree is valid.

    Example 1:

    Input: descriptions = [[-1,0,0],[0,1,1],[0,2,0]]
    Output: [0,1,2]

    Example 2:

    Input: descriptions = [[-1,0,0],[0,1,1],[0,2,0],[1,3,0],[1,4,1]]
    Output: [0,1,2,null,3,4]

     */

    // Link : https://leetcode.com/problems/create-binary-tree-from-array/

    public static void main(String[] args) {

        int[][] descriptions = {{-1, 0, 0}, {0, 1, 1}, {0, 2, 0}};

        TreeNode root = createTree(descriptions);

        System.out.println(root);

    }


    public static TreeNode createTree(int[][] descriptions) {

        HashSet<Integer> set = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        for (int[] description : descriptions) {

            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            set.add(parent);
            TreeNode parentNode;
            TreeNode childNode;

            if (!map.containsKey(parent)) {

                parentNode = new TreeNode(parent);
                map.put(parent, parentNode);

            } else
                parentNode = map.get(parent);

            if (!map.containsKey(child)) {

                childNode = new TreeNode(child);
                map.put(child, childNode);

            } else
                childNode = map.get(child);


            if (isLeft == 1)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;

        }

        for (int[] description : descriptions)
            set.remove(description[1]);

        List<Integer> list = new ArrayList<>(set);
        int parentVal = list.get(0);

        return map.get(parentVal);

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
