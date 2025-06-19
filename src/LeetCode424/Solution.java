package LeetCode424;

/**
 * Solution for LeetCode 424
 *
 * @see <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">LeetCode 424</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a sliding window + Two-Pointer technique.
 */

class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurrence = new int[26];
        int left = 0;
        int ans = 0;
        int maxOccurrence = 0;

        for (int right = 0; right < s.length(); right++) {
            maxOccurrence = Math.max(maxOccurrence, ++occurrence[s.charAt(right) - 'A']);
            if (right - left + 1 - maxOccurrence > k) {
                occurrence[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}