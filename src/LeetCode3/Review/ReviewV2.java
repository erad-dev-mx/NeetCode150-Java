package LeetCode3.Review;

import java.util.HashSet;

class ReviewV2 {
    // HashSet, left = 0, right = 0, answer = 0
    // abcabcbb
    // while char at ith position is not present in set, then add value and ++ right pointer
    // but if char at ith posirion is present in set, we remove char at left and increase this one
    // abc => bca => cab => abc => bc
    // We track which is the greater to return as answer
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int left = 0;
        int right = 0;
        int answer = 0;
        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            answer = Math.max(answer, right - left + 1);
            right++;
        }

        return answer;
    }
}