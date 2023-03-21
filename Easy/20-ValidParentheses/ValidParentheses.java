import java.util.Stack;

public class ValidParentheses {


    /*

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:

    Input: s = "(]"
    Output: false

     */

    // Link : https://leetcode.com/problems/valid-parentheses/

    public static void main(String[] args) {

        String s = "()[]{}";
        System.out.println(isValid(s));
        System.out.println(isValid2(s));


    }


    public static boolean isValid(String s) {

        int n = s.length();

        if(n % 2 != 0)
            return false;

        char[] stack = new char[n];
        int top = -1;

        for(int i = 0; i < n; i++){

            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[')
                stack[++top] = c;

            else{
                if(top == -1)
                    return false;
                char topChar = stack[top--];
                if(c == ')' && topChar != '(')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
            }

        }

        return top == -1;

    }

    public static boolean isValid2(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();

    }

}
