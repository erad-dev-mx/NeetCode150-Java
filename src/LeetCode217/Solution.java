package LeetCode217;

// https://leetcode.com/problems/contains-duplicate/

// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            if (seenNumbers.contains(num)) {
                return true; // Duplicate found
            }
            seenNumbers.add(num);
        }

        return false; // No duplicates found
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(solution.containsDuplicate(nums1)); // Expected output: true

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.containsDuplicate(nums2)); // Expected output: false

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(solution.containsDuplicate(nums3)); // Expected output: true

        int[] nums4 = {};
        System.out.println(solution.containsDuplicate(nums4)); // Expected output: false

        int[] nums5 = {1};
        System.out.println(solution.containsDuplicate(nums5)); // Expected output: false
    }
}
