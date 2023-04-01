package LeetCodeSolutions.Medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {

    /*
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

    A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

    Example:

    Input: "23"
    Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    Note:

    Although the above answer is in lexicographical order, your answer could be in any order you want.
    */

    // Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    public static void main(String[] args) {

        String digits = "23";

        for (String str : letterCombinations(digits))
            System.out.print(str + " ");

    }

    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if(digits.length() == 0)
            return list;

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(list, "", digits, 0, map);

        return list;


    }

    private static void backtrack(List<String> list, String temp, String digits, int start, String[] map){

        if(temp.length() == digits.length()){
            list.add(temp);
            return;
        }

        String letters = map[digits.charAt(start) - '0'];

        for(int i = 0; i < letters.length(); i++)
            backtrack(list, temp + letters.charAt(i), digits, start + 1, map);

    }

}
