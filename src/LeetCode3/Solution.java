package LeetCode3;

import java.util.HashSet;

/**
 * Solution for LeetCode 3
 *
 * @see <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LeetCode 3</a>
 * Time Complexity: O(N)
 * Space Complexity: O(min(N, M))
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

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "";
        System.out.println(solution.lengthOfLongestSubstring(s1));

        String s2 = "a";
        System.out.println(solution.lengthOfLongestSubstring(s2));

        String s3 = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s3));

        String s4 = "bmw";
        System.out.println(solution.lengthOfLongestSubstring(s4));
    }
}