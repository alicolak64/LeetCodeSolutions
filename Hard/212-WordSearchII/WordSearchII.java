import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    /*
    Given a 2D board and a list of words from the dictionary, find all words in the board.

    Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

    Example:

    Input:
    board = [
      ['o','a','a','n'],
      ['e','t','a','e'],
      ['i','h','k','r'],
      ['i','f','l','v']
    ]
    words = ["oath","pea","eat","rain"]

    Output: ["eat","oath"]
    Note:
    All inputs are consist of lowercase letters a-z.
    The values of words are distinct.
    */

    // Link : https://leetcode.com/problems/word-search-ii/

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> list = findWords(board, words);

        System.out.println(list);

    }

    public static List<String> findWords(char[][] board, String[] words) {

        List<String> list = new ArrayList<>();

        if (board == null || board.length == 0 || board[0].length == 0)
            return list;

        if (words == null || words.length == 0)
            return list;

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                dfs(board, visited, i, j, trie.root, list);

            }

        }

        return list;

    }

    private static void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, List<String> list) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return;

        if (visited[i][j])
            return;

        char c = board[i][j];

        if (node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }

        visited[i][j] = true;

        dfs(board, visited, i + 1, j, node, list);
        dfs(board, visited, i - 1, j, node, list);
        dfs(board, visited, i, j + 1, node, list);
        dfs(board, visited, i, j - 1, node, list);

        visited[i][j] = false;

    }

    static class TrieNode {

        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }

    }

    static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {

            TrieNode node = root;

            for (char c : word.toCharArray()) {

                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node = node.children[c - 'a'];

            }

            node.word = word;

        }

    }

}
