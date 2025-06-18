package LeetCode3;

import java.util.HashSet;

/**
 * Solution for LeetCode 3
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode 3</a>
 * Time Complexity:
 * Space Complexity:
 * This approach uses a sliding window and Two-Pointer technique.
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        HashSet<Character> set = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}