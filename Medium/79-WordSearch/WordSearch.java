public class WordSearch {

    /*
    Given a 2D board and a word, find if the word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

    Example:

    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    Given word = "ABCCED", return true.
    Given word = "SEE", return true.
    Given word = "ABCB", return false.
    */

    // Link : https://leetcode.com/problems/word-search/

    public static void main(String[] args) {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String word = "ABCCED";

        boolean result = exist(board, word);

        System.out.println(result);

    }

    public static boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        if (word == null || word.length() == 0)
            return true;

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (dfs(board, word, 0, i, j, visited))
                        return true;

                }

            }

        }

        return false;

    }

    public static boolean dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited) {

        if (index == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        boolean result = dfs(board, word, index + 1, row + 1, col, visited) ||
                dfs(board, word, index + 1, row - 1, col, visited) ||
                dfs(board, word, index + 1, row, col + 1, visited) ||
                dfs(board, word, index + 1, row, col - 1, visited);

        visited[row][col] = false;

        return result;

    }

}
