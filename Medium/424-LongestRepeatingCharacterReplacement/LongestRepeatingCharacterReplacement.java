public class LongestRepeatingCharacterReplacement {

    /*

           Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
            In one operation, you can choose any character of the string and change it to any other uppercase English character.
            Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
            Note:
            Both the string's length and k will not exceed 104.

            Example 1:
            Input:
            s = "ABAB", k = 2
            Output:
            4
            Explanation:
            Replace the two 'A's with two 'B's or vice versa.

            Example 2:
            Input:
            s = "AABABBA", k = 1
            Output:
            4
            Explanation:
            Replace the one 'A' in the middle with 'B' and form "AABBBBA".
            The substring "BBBB" has the longest repeating letters, which is 4.


     */

    // Link : https://leetcode.com/problems/longest-repeating-character-replacement/

    public static void main(String[] args) {

        String s = "ABAB";
        int k = 2;

        System.out.println(characterReplacement(s, k));

    }

    public static int characterReplacement(String s, int k) {

        int[] counts = new int[26];
        int max = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {

            int count = ++counts[s.charAt(end) - 'A'];
            max = Math.max(max, count);

            if (end - start + 1 - max > k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }

            end++;

        }

        return end - start;

    }

}
