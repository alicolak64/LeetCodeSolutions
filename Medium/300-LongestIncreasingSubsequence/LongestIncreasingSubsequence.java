import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /*
    * Given an unsorted array of integers, find the length of longest increasing subsequence.
    * Example:
    * Input: [10,9,2,5,3,7,101,18]
    * Output: 4
    * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    * Note:
    * There may be more than one LIS combination, it is only necessary for you to return the length.
    * Your algorithm should run in O(n2) complexity.
    * Follow up: Could you improve it to O(n log n) time complexity?
     */

    // Link : https://leetcode.com/problems/longest-increasing-subsequence/


    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] array) {

        int[] lis = new int[array.length];

        Arrays.fill(lis,1);

        for ( int i = 0 ; i < array.length ; i++ )
            for ( int j = 0 ; j < i ; j++ )
                if ( array[i] > array[j] )
                    lis[i] = Math.max(lis[i], lis[j] + 1 );



        int max = lis[ array.length - 1 ];

        for ( int element : lis)
            if (element > max)
                max = element;

        return max;
    }

}
