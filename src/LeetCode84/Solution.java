package LeetCode84;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println("Max area: " + solution.largestRectangleArea(heights1));

        int[] heights2 = {2, 4};
        System.out.println("Max area: " + solution.largestRectangleArea(heights2));

        int[] heights3 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Max area: " + solution.largestRectangleArea(heights3));

        int[] heights4 = {1, 2, 3, 4, 5};
        System.out.println("Max area: " + solution.largestRectangleArea(heights4));

        int[] heights5 = {5, 4, 3, 2, 1};
        System.out.println("Max area: " + solution.largestRectangleArea(heights5));
    }
}
