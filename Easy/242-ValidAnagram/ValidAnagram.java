package LeetCodeSolutions.Easy;

import java.util.Arrays;

public class ValidAnagram {

    /*

    Given two strings s and t , write a function to determine if t is an anagram of s.

    Example 1:

    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:

    Input: s = "rat", t = "car"
    Output: false

    Note:
    You may assume the string contains only lowercase alphabets.

     */

    // Link : https://leetcode.com/problems/valid-anagram/

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));


    }

    public static boolean isAnagram(String s, String t) {



        if ( s.length() != t.length() )
            return false;


        s = sort(s);
        t = sort(t);

        return s.equals(t);


    }

    public static String sort (String str) {

        char[] tempArray = str.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);

    }

}
