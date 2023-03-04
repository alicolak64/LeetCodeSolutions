import java.util.Arrays;

public class RunningSumOf1DArray {

    /*

    Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    Return the running sum of nums.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

    Example 2:
    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

    Example 3:
    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]

     */

    // Link : https://leetcode.com/problems/running-sum-of-1d-array/

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] result = runningSum(nums);
        System.out.println(Arrays.toString(result));

    }


    public static int[] runningSum(int[] nums) {

        int n = nums.length;

        int[] sums = new int[n];

        sums[0] = nums[0];

        for (int i = 1; i < n; i++)
            sums[i] = sums[i - 1] + nums[i];

        return sums;

    }

}
