package LeetCode150;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand
                int result = applyOperator(token, a, b);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    private int applyOperator(String operator, int a, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> -1;
        };
    }
}