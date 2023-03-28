public class PlusOne {

    /*

    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: digits = [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.

    Example 2:

    Input: digits = [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.

    Example 3:

    Input: digits = [0]
    Output: [1]

     */

    // Link : https://leetcode.com/problems/plus-one/

    public static void main(String[] args) {

        int[] digits = {9, 9, 9 , 1 , 2 , 3, 4 , 9 , 9 , 9};

        int[] result = plusOne(digits);

        for (int j : result) {
            System.out.print(j + " ");
        }

    }

    public static int[] plusOne(int[] digits) {

        if (!(digits[digits.length - 1] == 9))
            digits[digits.length - 1]++;

        else {

            int digit = digits.length - 1;

            while (digit != -1 && digits[digit] == 9) {
                digits[digit] = 0;
                digit--;
            }

            if (digit != -1)
                digits[digit]++;
            else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }

        }

        return digits;

    }

}
