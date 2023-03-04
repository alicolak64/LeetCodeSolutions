public class FibonacciNumber {

    /*

    The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), for N > 1.
    Given N, calculate F(N).

    Example 1:

    Input: 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

    Example 2:

    Input: 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

    Example 3:

    Input: 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

     */

    // Link : https://leetcode.com/problems/fibonacci-number/

    public static void main(String[] args) {

        int n = 4;
        System.out.println(fib(n));

    }

    public static int fib(int n) {

        if ( n == 0)
            return 0;
        else if ( n == 1 )
            return 1;

        int[] fib = new int[n + 1];  // create table

        fib[0] = 0; // base case
        fib[1] = 1; // base case

        for (int i = 2; i <= n; i++) // fill table
            fib[i] = fib[i - 1] + fib[i - 2];

        return fib[n]; // return result

    }

}
