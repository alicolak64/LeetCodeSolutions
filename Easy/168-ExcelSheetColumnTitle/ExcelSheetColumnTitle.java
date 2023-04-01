public class ExcelSheetColumnTitle {

    /*

    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:

    Input: columnNumber = 1
    Output: "A"

    Example 2:

    Input: columnNumber = 28
    Output: "AB"

    Example 3:

    Input: columnNumber = 701
    Output: "ZY"

    Example 4:

    Input: columnNumber = 2147483647
    Output: "FXSHRXW"

    */

    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }

        return sb.reverse().toString();

    }

}
