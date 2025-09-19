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

// My thoughts: To solve this problem we use a sliding window + two pointer approach. How? Well, we will use two
// pointers, left and right (in the code is i), and with the help of a formula (Length - Max or Most Repeated Char is
// less or equal to K) we will move our right pointer and sum one to our occurrences array, if the formula doesn't work
// we will increase left pointer and remove one from occurrences array. To our answer every time we loop we will update
// the value with the length (but just if it is greater). And that will be our answer.