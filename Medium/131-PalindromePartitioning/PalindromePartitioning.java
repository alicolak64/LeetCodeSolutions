import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    Example:

    Input: "aab"
    Output:
    [
      ["aa","b"],
      ["a","a","b"]
    ]
    */

    // Link : https://leetcode.com/problems/palindrome-partitioning/

    public static void main(String[] args) {

        String s = "aab";

        for (List<String> list : partition(s))
            for (String str : list)
                System.out.print(str + " ");

    }

    public static List<List<String>> partition(String s) {

        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;

    }

    private static void backtrack(List<List<String>> list, List<String> tempList, String s, int start){

        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{

            for(int i = start; i < s.length(); i++){

                if(isPalindrome(s, start, i)){

                    tempList.add(s.substring(start, i + 1));
                    backtrack(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);

                }

            }

        }

    }

    private static boolean isPalindrome(String s, int low, int high){

        while(low < high)
            if(s.charAt(low++) != s.charAt(high--)) return false;

        return true;

    }


}
