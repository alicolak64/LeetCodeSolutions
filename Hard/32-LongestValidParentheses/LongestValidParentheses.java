public class LongestValidParentheses {

    /*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    Example 1:

    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".

    Example 2:

    Input: s = ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()".

    Example 3:

    Input: s = ""
    Output: 0

     */

    // Link : https://leetcode.com/problems/longest-valid-parentheses/

    public static void main(String[] args) {

        String s = ")()())";
        System.out.println(longestValidParentheses(s));

    }

    public static int longestValidParentheses(String s) {

        int max = 0;

        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(')
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;

                max = Math.max(max, dp[i]);

            }

        }

        return max;

    }

}
