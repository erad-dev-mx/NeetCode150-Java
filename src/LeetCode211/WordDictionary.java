package LeetCode211;

// We will use TRIE
// Added words:
// pen, pot, cat, cars, bed
// Words to be search:
// pot, pts, .ar, ..t, ..ey
// - pot: TRUE
// - pots: We could find the last s so FALSE
// - .ar: when we see the dot we will search in each node
// until cars path we will find a match for this word. The answer is TRUE
// - ..t: TRUE
// .ey: there is no present in our true. We return FALSE
class WordDictionary {

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        
    }
    
    public boolean search(String word) {
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */