package LeetCode20.Review;

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

    }
}
