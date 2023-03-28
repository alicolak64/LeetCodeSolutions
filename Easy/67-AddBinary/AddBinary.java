public class AddBinary {

    /*

    Given two binary strings a and b, return their sum as a binary string.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"

    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"

     */

    // Link : https://leetcode.com/problems/add-binary/

    public static void main(String[] args) {

        String a = "11";
        String b = "1";

        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        int carry = 0;

        while (i >= 0 || j >= 0) {

            int sum = carry;

            if (j >= 0)
                sum += b.charAt(j--) - '0';

            if (i >= 0)
                sum += a.charAt(i--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;

        }

        if (carry != 0)
            sb.append(carry);

        return sb.reverse().toString();

    }

}
