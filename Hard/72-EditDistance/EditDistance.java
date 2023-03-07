public class EditDistance {

    /*
        * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
        * You have the following 3 operations permitted on a word:
        * Insert a character
        * Delete a character
        * Replace a character
        * Example 1:
        * Input: word1 = "horse", word2 = "ros"
        * Output: 3
        * Explanation:
        * horse -> rorse (replace 'h' with 'r')
        * rorse -> rose (remove 'r')
        * rose -> ros (remove 'e')
        * Example 2:
        * Input: word1 = "intention", word2 = "execution"
        * Output: 5
        * Explanation:
        * intention -> inention (remove 't')
        * inention -> enention (replace 'i' with 'e')
        * enention -> exention (replace 'n' with 'x')
        * exention -> exection (replace 'n' with 'c')
        * exection -> execution (insert 'u')
    */

        // Link : https://leetcode.com/problems/edit-distance/

    public static void main(String[] args) {

        


        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++)
            dp[i][0] = i;

        for (int j = 0; j <= length2; j++)
            dp[0][j] = j;

        //iterate though, and check last char
        for (int i = 0; i < length1; i++) {

            char c1 = word1.charAt(i);

            for (int j = 0; j < length2; j++) {

                char c2 = word2.charAt(j);

                //if last two chars equal
                if (c1 == c2)
                    dp[i + 1][j + 1] = dp[i][j]; //update dp value for +1 length

                else {

                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = Math.min(replace, insert);
                    min = Math.min(delete, min);
                    dp[i + 1][j + 1] = min;

                }

            }

        }

        return dp[length1][length2];

    }

}
