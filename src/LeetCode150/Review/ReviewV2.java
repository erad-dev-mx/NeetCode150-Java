package LeetCode150.Review;

public class ReviewV2 {
    // Operators: "+", "-", "/", "*"
    // Operand: 1 - N
    // 15 / 2 = 7.5 -> 7
    // Always is going to be valid

    // Itare through each token
    // Stack (LIFO)
    // If it's a number, push onto Stack
    // If it's an operator, pop the top two numbers
    // tokens = ["2","1","+","3","*"]
    // isOperator(2) -> Stack(2), isOperator(1) -> Stack(2, 1)
    // isOperator(+) -> 1 + 2 = 3 -> Stack(3), isOperator(3) -> Stack(3, 3)
    // isOperator(*) -> 3 * 3 = 9 -> Stack(9) -> 9
    // Time Complexity: O(N), Space Complexity: O(N)
    public int evalRPN(String[] tokens) {

    }
}
