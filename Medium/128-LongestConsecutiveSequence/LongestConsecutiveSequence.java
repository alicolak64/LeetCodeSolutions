import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*

    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    Your algorithm should run in O(n) complexity.

    Example1:

    Input: [100, 4, 200, 1, 3, 2]
    Output: 4
    Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
    
    Example2:
    
    Input: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
    Output: 9
    Explanation: The longest consecutive elements sequence is [0, 1, 2, 3, 4, 5, 6, 7, 8]. Therefore its length is 9.

     */

    // Link : https://leetcode.com/problems/longest-consecutive-sequence/

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {

        int longestStreak = 0;

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums)
            numSet.add(num);

        for (int num : numSet) {

            if (!numSet.contains(num - 1)) {

                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);

            }

        }

        return longestStreak;

    }

}
