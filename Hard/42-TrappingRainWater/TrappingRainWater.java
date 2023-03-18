public class TrappingRainWater {

    /*

    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Example 1:

    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:

    Input: height = [4,2,0,3,2,5]
    Output: 9
    Explanation: The above elevation map (black section) is represented by array [4,2,0,3,2,5]. In this case, 9 units of rain water (blue section) are being trapped.

     */

    // Link : https://leetcode.com/problems/trapping-rain-water/

    public static void main(String[] args) {

        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));

    }

    public static int trap(int[] height) {

        int maxArea = 0;

        int i = 0;
        int j = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (i < j) {

            if (height[i] < height[j]) {

                if (height[i] > leftMax)
                    leftMax = height[i];
                else
                    maxArea += leftMax - height[i];

                i++;

            } else {

                if (height[j] > rightMax)
                    rightMax = height[j];
                else
                    maxArea += rightMax - height[j];

                j--;

            }

        }

        return maxArea;

    }

}
