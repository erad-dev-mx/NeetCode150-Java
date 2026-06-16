package LeetCode211;

import java.util.HashMap;
import java.util.Map;

// We will use TRIE
// Added words:
// pen, pot, cat, cars, bed
// Words to search:
// pot, pts, .ar, ..t, ..ey
// - pot: TRUE
// - pots: We could find the last s so FALSE
// - .ar: when we see the dot we will search in each node
// until cars path we will find a match for this word. The answer is TRUE
// - ..t: TRUE
// .ey: there is no present in our true. We return FALSE
class WordDictionary {
    TrieNode trie;

    public WordDictionary() {
        trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = trie;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    public boolean search(String word) {
        return searchInNode(word, trie);
    }

    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    for (char x : node.children.keySet()) {
                        TrieNode child = node.children.get(x);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                node = node.children.get(ch);
            }
        }
        return node.word;
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;
    public TrieNode(){}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */