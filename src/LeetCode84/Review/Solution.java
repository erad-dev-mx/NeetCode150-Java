package LeetCode84.Review;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];

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

// Thoughts: To solve the problem we will use a stack that will help us. We will push the first element to the stack, if
// te next one is greater we will push that value in our stack but if it is less we will push the previous from the
// stack, and we will put out new value. In teh stack we are going to add the index value to access to the position and
// the value itself. When the heigh suddenly increase we will add the value to the stack because that means that the
// previous one is still valid. Just until we found a lower value we will pop the values from stack or if we reach to
// the end, also we are going to pop out the index value. Everytime we pop out a value we need to calculate the area and
// keep it in maxArea (well, just if it is the greatest at that moment).