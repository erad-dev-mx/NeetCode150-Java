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
class Trie {

    public Trie() {
        
    }
    
    public void insert(String word) {
        
    }
    
    public boolean search(String word) {
        
    }
    
    public boolean startsWith(String prefix) {
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */