public class ImplementTrie {

    /*
    Implement a trie with insert, search, and startsWith methods.

    Example:

    Trie trie = new Trie();

    trie.insert("apple");
    trie.search("apple");   // returns true
    trie.search("app");     // returns false
    trie.startsWith("app"); // returns true
    trie.insert("app");
    trie.search("app");     // returns true

    Note:

    You may assume that all inputs are consist of lowercase letters a-z.
    All inputs are guaranteed to be non-empty strings.
    */

    // Link : https://leetcode.com/problems/implement-trie-prefix-tree/

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true

    }

    static class Trie {

        static class TrieNode {

            private char val;
            private TrieNode[] links;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[26];
            }

            public TrieNode(char val) {
                this.val = val;
                links = new TrieNode[26];
            }

            public boolean containsKey(char c) {
                return links[c - 'a'] != null;
            }

            public TrieNode get(char c) {
                return links[c - 'a'];
            }

            public void put(char c, TrieNode node) {
                links[c - 'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }

        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {

            root = new TrieNode();

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {

            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                if (!node.containsKey(c))
                    node.put(c, new TrieNode());

                node = node.get(c);

            }

            node.setEnd();

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {

            TrieNode node = searchPrefix(word);

            return node != null && node.isEnd();

        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {

            TrieNode node = searchPrefix(prefix);

            return node != null;

        }

        private TrieNode searchPrefix(String word) {

            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {

                char c = word.charAt(i);

                if (node.containsKey(c))
                    node = node.get(c);
                else
                    return null;

            }

            return node;

        }

    }

}
