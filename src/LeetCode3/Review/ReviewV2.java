package LeetCode3.Review;

class ReviewV2 {
    // HashSet, left = 0, right = 0, answer = 0
    // abcabcbb
    // while char at ith position is not present in set, then add value and ++ right pointer
    // but if char at ith posirion is present in set, we remove char at left and increase this one
    // abc => bca => cab => abc => bc
    // We track which is the greater to return as answer
    public int lengthOfLongestSubstring(String s) {

    }
}