import java.util.Arrays;

public class ProductofArrayExceptSelf {

    /*
    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Example 1:

    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Note: Please solve it without division and in O(n).

    Example 2:

    Input:  [-1,1,0,-3,3]
    Output: [0,0,9,0,0]
    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
     */

    // Link : https://leetcode.com/problems/product-of-array-except-self/

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

    }



    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = product;
            product *= nums[i];
        }

        product = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= nums[i];
        }

        return result;

    }

}
