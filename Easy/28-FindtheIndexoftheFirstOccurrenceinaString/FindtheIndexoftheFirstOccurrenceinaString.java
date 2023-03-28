public class FindtheIndexoftheFirstOccurrenceinaString {

    /*

    Given a string s and a character c that occurs in s, return the index of the first occurrence of c in s that appears at or after index start.

    Example 1:

    Input: s = "hello", c = "l", start = 0
    Output: 2

    Example 2:

    Input: s = "hello", c = "l", start = 2
    Output: 3

    Example 3:

    Input: s = "hello", c = "l", start = 3
    Output: 3

    Example 4:

    Input: s = "hello", c = "l", start = 4
    Output: -1

    Example 5:

    Input: s = "hello", c = "l", start = 5
    Output: -1

     */

    // Link : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-of-a-string-in-another-string/

    public static void main(String[] args) {

        String haystack = "hello";
        String  needle = "ll";

        System.out.println(strStr(haystack, needle));


    }

    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;

        if (haystack.length() == 0)
            return -1;

        for (int i = 0; i < haystack.length(); i++) {

            if (haystack.charAt(i) == needle.charAt(0)) {

                int j = 0;

                while (j < needle.length() && i + j < haystack.length() && haystack.charAt(i + j) == needle.charAt(j))
                    j++;

                if (j == needle.length())
                    return i;

            }

        }

        return -1;


    }

}
