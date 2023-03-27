public class PalindromeNumber {

    /*

    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

    Follow up: Could you solve it without converting the integer to a string?

    Example 1:

    Input: x = 121
    Output: true

    Example 2:

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:

    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

    Example 4:

    Input: x = -101
    Output: false

     */

    // Link : https://leetcode.com/problems/palindrome-number/

    public static void main(String[] args) {

        int x = 121;

        System.out.println(isPalindrome(x));

    }

    public static boolean isPalindrome(int x) {

        // StringBuiler.reverse solution
        // return String.valueOf(x).equals(new StringBuilder(String.valueOf(x)).reverse().toString());

        if (x < 0)
            return false;

        int reverse = 0;
        int temp = x;

        while (temp != 0) {

            reverse = reverse * 10 + temp % 10;
            temp /= 10;

        }

        return reverse == x;

    }

}
