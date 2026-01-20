package LeetCode128.Review;

import java.util.HashSet;

public class ReviewV2 {
    // HashSet
    // Keep track longestSeq
    // Run HashSet just if our HashSet doesn’t contain a minus one element (cause that means the value we are is the
    // beginning of our sequence)
    // Using a while loop we will keep moving forward to find all consecutive
    // This value will be saved in a new variable and at the end we will check which of these of two is the grater

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSequence = 1;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }
}
