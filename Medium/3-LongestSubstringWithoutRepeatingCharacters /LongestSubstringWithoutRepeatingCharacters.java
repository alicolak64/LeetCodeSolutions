public class LongestSubstringWithoutRepeatingCharacters {

    /*

        Given a string, find the length of the longest substring without repeating characters.

        Example 1:
        Input: "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.

        Example 2:
        Input: "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.

        Example 3:
        Input: "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


     */

    // Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/


    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;
        int i = 0;
        int j = 0;
        int[] count = new int[256];

        while (j < s.length()) {

            if (count[s.charAt(j)] == 0) {
                count[s.charAt(j)]++;
                j++;
                max = Math.max(max, j - i);
            } else {
                count[s.charAt(i)]--;
                i++;
            }

        }

        return max;

    }

}
