package LeetCode212;

import java.util.List;

// Brute force
// X | H | B
// A | B | O
// Y | C | Z
// Words: HBO, XYZ, ABC
// We will see if a character in our matrix matches with the starting letter of our word
// If it matches, then we search in the subsequence and neighbors
// For X, its neighbors are H and A so we go to next one
// For H, we found B and O, so we add HBO to our answer
// For A, we found B and C, so we add ABC to our answer
// We run the rest of the elements
// For a better aprroach we could use a TRIE
// E | F | R | T
// L | A | A | N
// G | O | T | G
// G | O | L | F
// Words: META, GOOGLE, FANNG
// First, we create a TRIE with the words
// Now we traverse through our MATRIX comparing the elements with our TRIE
// We skip E, but F is in our TRIE so we will run to see if there is the entire word (YES IT IS)
// Skip R, T, L, A, A, N, until G so we will run but after a few steps we see the word isn't complete
// Skip O, T, we validate the following G's and there is GOOGLE
// Skip L and F. We return FAANG, GOOGLE as our answer.
// Time: O (m (4x  3^ L - 1))
// Space: O (n)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
    }
}