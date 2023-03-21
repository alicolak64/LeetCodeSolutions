import java.util.Stack;

public class EvaluateReversePolishNotation {

    /*

    You are given a string s representing an expression. The expression contains the operators '+', '-', '*', and '/' on non-negative integers and parentheses '(' and ')'.
    For example, "3+2*2" and "(1+(4+5+2)-3)+(6+8)" are valid expressions but "3+5*(" and "3+5*2)" are not valid expressions.

    Your task is to evaluate the expression and return the result's value.

    Note that :

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

    Example 1:

    Input: s = ["2","1","+","3","*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

    Example 2:

    Input: s = ["4","13","5","/","+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

    Example 3:

    Input: s = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    Output: 22
    Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5

     */

    // Link : https://leetcode.com/problems/evaluate-reverse-polish-notation/


    public static void main(String[] args) {

        String[] s = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(s));

        s = new String[]{"4","13","5","/","+"};
        System.out.println(evalRPN(s));

        s = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s));

    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            switch (token) {

                case "+" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                }

                case "-" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                }

                case "*" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                }

                case "/" -> {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                }

                default ->
                        stack.push(Integer.parseInt(token));

            }

        }

        return stack.pop();

    }

}
