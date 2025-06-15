package LeetCode11;

/**
 * Solution for LeetCode 11
 *
 * @see <a href="https://leetcode.com/problems/container-with-most-water/">LeetCode 11</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a Two-Pointer technique
 */

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int area = Math.min(height[left], height[right]) * width;

            max = Math.max(max, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max area: " + solution.maxArea(heights1));

        int[] heights2 = {5, 5, 5, 5, 5};
        System.out.println("Max area: " + solution.maxArea(heights2));

        int[] heights3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Max area: " + solution.maxArea(heights3));
    }
}