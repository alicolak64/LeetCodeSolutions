public class FindtheDuplicateNumber {

    /*

    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

    There is only one repeated number in nums, return this repeated number.

    You must solve the problem without modifying the array nums and uses only constant extra space.

    Example 1:

    Input: nums = [1,3,4,2,2]
    Output: 2

    Example 2:

    Input: nums = [3,1,3,4,2]
    Output: 3

    Example 3:

    Input: nums = [1,1]
    Output: 1

     */

    // Link : https://leetcode.com/problems/find-the-duplicate-number/

    public static void main(String[] args) {

        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));

    }

    public static int findDuplicate(int[] nums) {

        int first = nums[0];
        int second = nums[0];

        do {
            first = nums[first];
            second = nums[nums[second]];
        } while (first != second);

        second = nums[0];

        while (first != second) {
            first = nums[first];
            second = nums[second];
        }

        return first;

    }

}
