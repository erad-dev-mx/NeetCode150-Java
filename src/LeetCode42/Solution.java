package LeetCode42;

/**
 * Solution for LeetCode 42
 *
 * @see <a href="https://leetcode.com/problems/trapping-rain-water/">LeetCode 42</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses a Two-Pointer technique
 */

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int total = 0;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                if (leftMax - height[left] > 0) {
                    total = total + leftMax - height[left];
                }
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                if (rightMax - height[right] > 0) {
                    total = total + rightMax - height[right];
                }
                right--;
            }
        }
        return total;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] heights1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped water: " + solution.trap(heights1));

        int[] heights2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Trapped water: " + solution.trap(heights2));

        int[] heights3 = {2, 0, 2};
        System.out.println("Trapped water: " + solution.trap(heights3));
    }
}
