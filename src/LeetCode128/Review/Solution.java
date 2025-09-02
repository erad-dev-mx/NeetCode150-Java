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

// My thoughts: This problem can be solved using Binary Search and then with the help of some variables we can reach
// The longest consecutive in the array but that solution is using O (N Log (n)) time because of the BS and the effort
// to find the longest consecutive. A better approach is using a HashSet we will run a loop to fill the Data Structure
// with the values (and eliminating duplicates). Having the numSet we can see if the value in the loop is part of a
// sequence and if is not we will use a couple of variables to track the current number and the current longest
// subsequence. At the end, we will just validate which value is greater, the current value of longest subsequence or
// the temporary that we are tracking inside our loop.