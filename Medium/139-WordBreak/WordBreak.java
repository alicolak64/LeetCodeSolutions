import java.util.List;

public class WordBreak {

    /*

    Given a string s and a dictionary of strings wordDict,
    return true if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.

    Example 1:

    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".

    Example 2:

    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

    Note that you are allowed to reuse a dictionary word.

     */

    // Link : https://leetcode.com/problems/word-break/

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        System.out.println(wordBreak(s, wordDict));

    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        return wordBreak(s, wordDict.toArray(new String[0]));

    }

    public static boolean wordBreak(String s, String[] wordDict) {

        if (s == null || s.length() == 0)
            return false;

        if (wordDict == null || wordDict.length == 0)
            return false;

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && contains(wordDict, s.substring(j, i))) {

                    dp[i] = true;
                    break;

                }

            }

        }

        return dp[s.length()];

    }

    public static boolean contains(String[] wordDict, String word) {

        for (String s : wordDict)
            if (s.equals(word))
                return true;

        return false;

    }


}
