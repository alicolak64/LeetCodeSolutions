public class LongestCommonSubsequence {

    /*

    Given two strings text1 and text2, return the length of their longest common subsequence.

    A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

    If there is no common subsequence, return 0.

    Example 1:

    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.

    Example 2:

    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.

    Example 3:

    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.

    Note:

    1. 1 <= text1.length <= 1000
    2. 1 <= text2.length <= 1000
    3. The input strings consist of lowercase English characters only.


     */

    // Link : https://leetcode.com/problems/longest-common-subsequence/


    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));

    }

    public static int longestCommonSubsequence(String string1, String string2) {

        int[][] lcs = new int[string1.length() + 1][string2.length() + 1]; // create table

        for (int i = 0; i <= string1.length(); i++) // fill table

            for (int j = 0; j <= string2.length(); j++) {

                if (i == 0 || j == 0) // base case
                    lcs[i][j] = 0;
                else if (string1.charAt(i - 1) == string2.charAt(j - 1)) // if characters match
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                else // if characters don't match
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);

            }

        return lcs[string1.length()][string2.length()];

    }


}
