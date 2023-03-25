public class DesignAddandSearchWordsDataStructure {

    /*
    Design a data structure that supports the following two operations:

    void addWord(word)
    bool search(word)
    search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

    Example:

    addWord("bad")
    addWord("dad")
    addWord("mad")
    search("pad") -> false
    search("bad") -> true
    search(".ad") -> true
    search("b..") -> true
    Note:
    You may assume that all words are consist of lowercase letters a-z.
    */

    // Link : https://leetcode.com/problems/design-add-and-search-words-data-structure/

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // -> false
        System.out.println(wordDictionary.search("bad")); // -> true
        System.out.println(wordDictionary.search(".ad")); // -> true
        System.out.println(wordDictionary.search("b..")); // -> true

    }

    static class WordDictionary {

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

        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode(currentChar));
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            return search(word, root, 0);
        }

        private boolean search(String word, TrieNode node, int index) {
            if (index == word.length()) {
                return node.isEnd();
            }
            char currentChar = word.charAt(index);
            if (currentChar == '.') {
                for (int i = 0; i < node.links.length; i++) {
                    if (node.links[i] != null && search(word, node.links[i], index + 1)) {
                        return true;
                    }
                }
            } else {
                if (node.containsKey(currentChar)) {
                    return search(word, node.get(currentChar), index + 1);
                }
            }
            return false;
        }

    }

}
