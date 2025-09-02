package LeetCode128.Review;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

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

                longestSub = Math.max(currentSub, longestSub);
            }
        }

        return longestSub;
    }
}