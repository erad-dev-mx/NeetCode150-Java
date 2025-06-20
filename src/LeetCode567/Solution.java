package LeetCode567;

/**
 * Solution for LeetCode 567
 *
 * @see <a href="https://leetcode.com/problems/permutation-in-string/">LeetCode 567</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a sliding window technique.
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Initialize frequency maps for s1 and the first window for s2
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Map, s2Map)) {
                return true;
            }

            s2Map[s2.charAt(i + s1.length()) - 'a']++; // adding new char to window
            s2Map[s2.charAt(i) - 'a']--; // removing old char from window
        }

        return matches(s1Map, s2Map);
    }

    // Compare two frequency maps
    private boolean matches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}