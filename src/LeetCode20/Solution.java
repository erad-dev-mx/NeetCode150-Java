package LeetCode20;

import java.util.HashMap;
import java.util.Stack;

/**
 * Solution for LeetCode 20
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">LeetCode 20</a>
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */


class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> mappedBrackets = new HashMap<>();

        mappedBrackets.put(')', '(');
        mappedBrackets.put('}', '{');
        mappedBrackets.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!mappedBrackets.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topElement = stack.pop();
                if (topElement != mappedBrackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        test(solution, "()");
        test(solution, "()[]{}");
        test(solution, "{[()]}");
        test(solution, "");
        test(solution, "(]");
        test(solution, "([)]");
        test(solution, "(");
        test(solution, ")");
        test(solution, "({[)");
    }

    private static void test(Solution solution, String input) {
        boolean result = solution.isValid(input);
        System.out.println(result);
    }
}