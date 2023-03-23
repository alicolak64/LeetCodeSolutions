public class Searcha2DMatrix {

    /*

        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.

        Example 1:
        Input:
        matrix = [
          [1,   3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 50]
        ]
        target = 3
        Output: true

        Example 2:
        Input:
        matrix = [
          [1,   3,  5,  7],
          [10, 11, 16, 20],
          [23, 30, 34, 50]
        ]
        target = 13
        Output: false

    */

    // Link : https://leetcode.com/problems/search-a-2d-matrix/

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        int target = 3;

        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int midElement = matrix[mid / n][mid % n];

            if (midElement == target)
                return true;
            else if (midElement < target)
                start = mid + 1;
            else
                end = mid - 1;

        }

        return false;

    }

}
