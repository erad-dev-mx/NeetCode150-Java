package LeetCode424;



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