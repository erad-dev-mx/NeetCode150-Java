package LeetCode3.Review;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

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

// To solve this problem it was necessary to implement a sliding window plus two pointer approach. How it works? Well,
// at the beginning we will have our pointer in the first position (index zero). Then we will check if the HashSet
// contains the character we will remove from it, and we will increase the value of left pointer, otherwise we will add
// the value to the HashSet and we will increase value of right pointer.