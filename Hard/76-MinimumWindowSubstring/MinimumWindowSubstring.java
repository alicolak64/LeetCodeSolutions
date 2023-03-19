public class MinimumWindowSubstring {

    /*

        Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

        Example 1:

        Input: S = "ADOBECODEBANC", T = "ABC"
        Output: "BANC"
        Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string T.

        Example 2:

        Input: S = "a", T = "a"
        Output: "a"
        Explanation: The entire string S is the minimum window.

        Example 3:

        Input: S = "a", T = "aa"
        Output: ""
        Explanation: Both 'a's from T must be included in the window.


        Note:
        If there is no such window in S that covers all characters in T, return the empty string "".
        If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

     */

    // Link : https://leetcode.com/problems/minimum-window-substring/

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

    }


    public static String minWindow(String s, String t) {

        int[] count = new int[256];
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        int countT = t.length();

        for (char c : t.toCharArray())
            count[c]++;

        while (j < s.length()) {

            if (count[s.charAt(j)] > 0)
                countT--;

            count[s.charAt(j)]--;
            j++;

            while (countT == 0) {

                if (j - i < min) {
                    min = j - i;
                    minStart = i;
                    minEnd = j;
                }

                count[s.charAt(i)]++;

                if (count[s.charAt(i)] > 0)
                    countT++;

                i++;

            }

        }

        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd);

    }

}
