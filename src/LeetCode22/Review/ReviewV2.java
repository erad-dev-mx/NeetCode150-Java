package LeetCode22.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewV2 {
    // 1. Placement: Add '(' if open < n
    // 2. Validity:  Add ')' if close < open (prevents starting with ')' or closing too many)
    // 3. Base Case: If length == 2 * n, we found a valid combination.

    // (open, close) -> path
    // (0,0) ""
    //      (1,0) "("
    //      (2,0) "((" -> (2,1) "(()" -> (2,2) "(())" [BASE CASE]
    //      (1,1) "()" -> (2,1) "()(" -> (2,2) "()()" [BASE CASE]
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        backtracking(ans, new StringBuilder(), 0, 0, n);

        return ans;
    }

    private void backtracking(
            List<String> ans,
            StringBuilder current,
            int open,
            int close,
            int max
    ) {
        if (current.length() == max * 2) {
            ans.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            backtracking(ans, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // BACKTRACK: Clean up for next branch
        }
        if (close < open) {
            current.append(")");
            backtracking(ans, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // BACKTRACK: Clean up for next branch
        }
    }
}
