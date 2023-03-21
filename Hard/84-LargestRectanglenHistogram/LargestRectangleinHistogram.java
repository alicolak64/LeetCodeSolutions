public class LargestRectangleinHistogram {

    /*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

    Example 1:

    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.

    Example 2:

    Input: heights = [2,4]
    Output: 4

     */

    // Link : https://leetcode.com/problems/largest-rectangle-in-histogram/

    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));

    }

    public static int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        int[] stack = new int[heights.length];

        int top = -1;

        for (int i = 0; i < heights.length; i++) {

            while (top != -1 && heights[stack[top]] > heights[i]) {

                int height = heights[stack[top--]];
                int width = top == -1 ? i : i - stack[top] - 1;

                maxArea = Math.max(maxArea, height * width);

            }

            stack[++top] = i;

        }

        while (top != -1) {

            int height = heights[stack[top--]];
            int width = top == -1 ? heights.length : heights.length - stack[top] - 1;

            maxArea = Math.max(maxArea, height * width);

        }

        return maxArea;

    }

}
