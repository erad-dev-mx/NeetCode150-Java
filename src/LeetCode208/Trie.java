package LeetCode208;

// faang, maang, fan, maa
// In the case of maa we don't add the End because is a prefix of maang
// ()
// (f)      (m)
// (a) (n)  (a)
// (a) (end)(a)
// (n)      (n)
// (g)      (g)
// (End)    (End)
// INSERT METHOD: apple, google, amazon, amazing
// We check if the first chart exists in a determinate branch and the end we add end node
// For apple we create a new branch with a, p, p, l, e, end
// For google we create a new branch with g, o, o, g, l, e, end
// For amazon we can use a from apple and then create a new branch with m, a, z, o, n, end
// For amazing a, m, a, z are already present so we create a new branch in z with i, n, g, end
// SEARCH METHOD: amazing, good, googler, app
// amazing, we check if on of our children starts with a and then we try to complete all the word (TRUE)
// good, g is present, then two o's are present but we don't have a branch with d (FALSE)
// google, until e everhing exists but there is no r (FALSE)
// app, three words exist but there is no end (FALSE)
// STARTS WITH METHOD: ama, apk, good, apple
// ama, there is present in amazon/amazing path (TRUE)
// apk, in the p we don't have a k children (FALSE)
// good, the last o don't have a d children (FALSE)
// apple, we have the word (TRUE)
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */