public class Sqrtx {

    /*

    Given a non-negative integer x, compute and return the square root of x.

    Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

    Example 1:

    Input: x = 4
    Output: 2

    Example 2:

    Input: x = 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

    */

    // Link : https://leetcode.com/problems/sqrtx/

    public static void main(String[] args) {

        int x = 1;

        System.out.println(mySqrt(x));

    }

    public static int mySqrt(int x) {

        //return (int) Math.sqrt(x);

        if (x == 0)
            return 0;
        else if (x == 1)
            return 1;

        int left = 1;
        int right = x;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (mid > x / mid)
                right = mid;
            else
                left = mid + 1;

        }

        return left - 1;

    }

}
