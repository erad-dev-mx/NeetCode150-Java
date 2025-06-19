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

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(solution.characterReplacement(s1, k1)); // Output: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(solution.characterReplacement(s2, k2)); // Output: 4

        String s3 = "AAAA";
        int k3 = 2;
        System.out.println(solution.characterReplacement(s3, k3)); // Output: 4

        String s4 = "ABCDE";
        int k4 = 1;
        System.out.println(solution.characterReplacement(s4, k4)); // Output: 2
    }
}