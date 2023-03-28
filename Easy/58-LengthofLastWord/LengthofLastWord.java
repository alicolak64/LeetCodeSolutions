public class LengthofLastWord {

    /*

    Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.

    A word is a maximal substring consisting of non-space characters only.

    Example 1:

    Input: s = "Hello World"
    Output: 5

    Example 2:

    Input: s = " "
    Output: 0

     */

    // Link : https://leetcode.com/problems/length-of-last-word/

    public static void main(String[] args) {

        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {

        if (s.length() == 0)
            return 0;

        if (s.length() == 1 && s.charAt(0) == ' ')
            return 0;

        s = s.trim();

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == ' ')
                break;

            count++;

        }

        return count;

    }

}
