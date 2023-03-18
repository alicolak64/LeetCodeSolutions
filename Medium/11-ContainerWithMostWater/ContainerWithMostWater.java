public class ContainerWithMostWater {

    /*

    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
    Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    Example 1:

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:

    Input: height = [1,1]
    Output: 1

     */

    // Link : https://leetcode.com/problems/container-with-most-water/

    public static void main(String[] args) {

        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(new ContainerWithMostWater().maxArea(height));

    }

    public int maxArea(int[] height) {

        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {

            int area = Math.min(height[i], height[j]) * (j - i);

            if (area > maxArea)
                maxArea = area;

            if (height[i] < height[j])
                i++;
            else
                j--;

        }

        return maxArea;

    }

}
