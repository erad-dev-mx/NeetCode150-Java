package LeetCode22.Review;

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

    }
}
