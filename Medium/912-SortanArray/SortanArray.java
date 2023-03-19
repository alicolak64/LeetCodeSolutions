import java.util.Arrays;

public class SortanArray {

    /*

        Given an array of integers nums, sort the array in ascending order.

        Example 1:
        Input: [5,2,3,1]
        Output: [1,2,3,5]

        Example 2:
        Input: [5,1,1,2,0,0]
        Output: [0,0,1,1,2,5]

        Note:
        1 <= A.length <= 10000
        -50000 <= A[i] <= 50000

    */

    // Link : https://leetcode.com/problems/sort-an-array/

    public static void main(String[] args) {

        int[] nums = {5, 2, 3, 1};
        System.out.println(Arrays.toString(sortArray(nums)));

    }

    public static int[] sortArray(int[] nums) {

        Arrays.sort(nums);
        return nums;

    }

}
