import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    /*

        Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

        Example:

        Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
        Output: [3,3,5,5,6,7]
        Explanation:

        Window position                Max
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
         1 [3  -1  -3] 5  3  6  7       3
         1  3 [-1  -3  5] 3  6  7       5
         1  3  -1 [-3  5  3] 6  7       5
         1  3  -1  -3 [5  3  6] 7       6
         1  3  -1  -3  5 [3  6  7]      7

        Note:
        You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

        Follow up:
        Could you solve it in linear time?

     */

    // Link : https://leetcode.com/problems/sliding-window-maximum/

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int left  = 0;
        int right = 0;

        while (right < nums.length) {

            if (queue.isEmpty())
                queue.add(nums[right]);

            else {

                while (!queue.isEmpty() && nums[right] > queue.peekLast())
                    queue.pollLast();

                queue.add(nums[right]);

            }

            if (right - left + 1 == k) {

                result[left] = queue.peek();

                if (nums[left] == queue.peek()) 
                    queue.pollFirst();

                left++;

            }

            right++;

        }

        return result;

    }



}
