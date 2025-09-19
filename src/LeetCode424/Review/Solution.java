package LeetCode424.Review;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] occurrence = new int[26];
        int left = 0;
        int ans = 0;
        int maxOccurrence = 0;

        for (int i = 0; i < s.length(); i++) {
            maxOccurrence = Math.max(maxOccurrence, ++occurrence[s.charAt(i) - 'A']);
            if (i - left + 1 - maxOccurrence > k) {
                occurrence[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}