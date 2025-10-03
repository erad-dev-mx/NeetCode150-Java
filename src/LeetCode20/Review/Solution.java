package LeetCode20.Review;

import java.util.HashMap;
import java.util.Stack;

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

// My thoughts: To solve the problem we will use two DS: HashMap and Stack. In the HashMap we will save all the brackets
// values setting key as the close bracket and value as the open bracket. In the Stack we will set all the open brackets
// of the string (that's what happened in the first if). If we found a close bracket we will validate if the topElement
// of the stack is equal to the value of that key if it is not, we will return false because that means, is not a valid
// string. At the end, if the stack is empty it means that it is a valid string.