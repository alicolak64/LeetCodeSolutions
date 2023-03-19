public class PermutationinString {

    /*

        Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

        Example 1:
        Input:s1 = "ab" s2 = "eidbaooo"
        Output:True
        Explanation: s2 contains one permutation of s1 ("ba").

        Example 2:
        Input:s1= "ab" s2 = "eidboaoo"
        Output: False

        Note:
        The input strings only contain lower case letters.
        The length of both given strings is in range [1, 10,000].

     */

    // Link : https://leetcode.com/problems/permutation-in-string/

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));

    }

    public static boolean checkInclusion(String s1, String s2) {

        int[] count = new int[26];

        for (char c : s1.toCharArray())
            count[c - 'a']++;

        int start = 0;
        int end = 0;
        int max = 0;

        while (end < s2.length()) {

            if (count[s2.charAt(end) - 'a'] > 0) {
                count[s2.charAt(end) - 'a']--;
                end++;
                max = Math.max(max, end - start);
            } else {
                count[s2.charAt(start) - 'a']++;
                start++;
            }

        }

        return max == s1.length();

    }

}
