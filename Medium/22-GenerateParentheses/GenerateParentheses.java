import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]

    Example 2:

    Input: n = 1
    Output: ["()"]

     */

    // Link : https://leetcode.com/problems/generate-parentheses/

    public static void main(String[] args) {

        int n = 3;
        System.out.println(new GenerateParentheses().generateParenthesis(n));

    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        generateParenthesis(list, "", 0, 0, n);
        return list;

    }

    public void generateParenthesis(List<String> list, String str, int open, int close, int max){

        if(str.length() == max * 2){
            list.add(str);
            return;
        }

        if(open < max)
            generateParenthesis(list, str + "(", open + 1, close, max);

        if(close < open)
            generateParenthesis(list, str + ")", open, close + 1, max);

    }


}
