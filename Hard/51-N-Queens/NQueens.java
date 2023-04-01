import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /*

    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

    Example:

    Input: 4
    Output: [
     [".Q..",  // Solution 1
      "...Q",
      "Q...",
      "..Q."],

     ["..Q.",  // Solution 2
      "Q...",
      "...Q",
      ".Q.."]
    ]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

    */

    // Link : https://leetcode.com/problems/n-queens/

    public static void main(String[] args) {

        int n = 4;

        for (List<String> list : solveNQueens(n))
            for (String str : list)
                System.out.println(str);

    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
        return list;

    }

    private static void backtrack(List<List<String>> list, List<String> tempList, int n, int row, boolean[] cols, boolean[] d1, boolean[] d2) {

        if (row == n)
            list.add(new ArrayList<>(tempList));

        else {

            for (int col = 0; col < n; col++) {

                int id1 = col - row + n;
                int id2 = col + row;
                if (cols[col] || d1[id1] || d2[id2])
                    continue;
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[col] = 'Q';
                String rowString = new String(charArray);
                tempList.add(rowString);
                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                backtrack(list, tempList, n, row + 1, cols, d1, d2);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
                tempList.remove(tempList.size() - 1);

            }
        }

    }

}
