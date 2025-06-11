package LeetCode128;

import java.util.HashSet;

/**
 * Solution for LeetCode 128

 *
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/">LeetCode 128</a>
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * This approach uses a HashSet to store the numbers and checks for consecutive sequences.
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub = 1;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSub = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSub++;
                }

                longestSub = Math.max(longestSub, currentSub);
            }
        }

        return longestSub;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = solution.longestConsecutive(nums);
        System.out.println(result); // Output: 4
    }
}
