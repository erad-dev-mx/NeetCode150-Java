package LeetCode20.Review;

import java.util.HashMap;
import java.util.Stack;

public class ReviewV2 {
    // '(',')','[',']','{','}'

    // Stack -> LIFO
    // HashMap = { '(',')','[',']','{','}' }

    // s = "{[]}"
    // char='{': Not in map -> Stack: ['{']
    // char='[': Not in map -> Stack: ['{', '[']
    // char=']': In map! Pair is '['. Stack pop is '['. Match! -> Stack: ['{']
    // char='}': In map! Pair is '{'. Stack pop is '{'. Match! -> Stack: []
    // Result: Stack is empty -> True.
    //
    // - "]" -> Stack empty on first closing char -> return False.
    // - "([" -> Stack not empty at end -> return False.
    public boolean isValid(String s) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!brackets.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char topElement = stack.pop();
                if (topElement != brackets.get(c)) return false;
            }
        }

        return stack.isEmpty();
    }
}
