package LeetCode17;

import java.util.ArrayList;
import java.util.List;

// Imagine we have this combination 46
// Our result is going to be: gm, g, go, hm, hn, ho, im, in, io
// How to solve it?
// We only have 2...9 so we can store each number's values in a HashMap
// Or we can crete an array and based on position we fill each position with values
// Image we have this input 2,3
//     [2](length of 3)
// a    b   c
// We created a decision tree, then we will add the entries from 3 in each branch
// ad, ac, af, bd,be, bf, cd, ce, cf
// We will use the length once we have that number of combination to finish that backtrack
class Solution {
    private String[] digitToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;
        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, String currentCombination, int index) {
        if (index == digits.length()) {
            combinations.add(currentCombination);
            return;
        }

        String letters = digitToLetters[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            backtrack(combinations, digits, currentCombination + letter, index + 1);
        }
    }
}