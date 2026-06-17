package LeetCode212;

import java.util.ArrayList;
import java.util.HashMap;
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
    char[][] fullboard = null;
    ArrayList<String> answer = new ArrayList<String>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }

        this.fullboard = board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }

        return answer;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = fullboard[row][col];
        TrieNode currNode = parent.children.get(letter);

        if (currNode.word != null) {
            this.answer.add(currNode.word);
            currNode.word = null;
        }

        fullboard[row][col] = '#';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if (
                    newRow < 0 || newCol < 0 ||
                            newRow >= fullboard.length ||
                            newCol >= fullboard[0].length) {
                continue;
            }
            if (currNode.children.containsKey(fullboard[newRow][newCol])) {
                backtracking(newRow, newCol, currNode);
            }
        }

        fullboard[row][col] = letter;

        if (currNode.children.isEmpty()) parent.children.remove(letter);
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;

    public TrieNode(){};
}