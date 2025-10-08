package LeetCode22.Review;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtrack(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            ans.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            backtrack(ans, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            current.append(")");
            backtrack(ans, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}