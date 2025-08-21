package LeetCode217.Review;

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true;
            }
            seenNumbers.add(num);
        }

        return false;
    }
}

// My thoughts: Here we use a HashSet to determine if the array contains a duplicate number