package LeetCode84.Review;

import java.util.Stack;

public class ReviewV2 {
    // I use an increasing stack
    // When I see a smaller height, I calculate area for previous bars.
    // Each smaller height will be pop out from stack.
    // heights = [2, 1, 5, 6, 2, 3]
    // i = 0 -> height = 2 -> push -> [0]
    // i = 1 → height = 1
    // 1 < 2 -> pop 2
    // height = 2, width = 1 -> area = 2
    // push 1 -> [1]
    // i = 2 -> height = 5 -> push -> [1,2]
    // i = 3 -> height = 6 -> push -> [1,2,3]
    // i = 4 -> height = 2
    // 2 < 6 -> pop 6
    // width = 1 -> area = 6
    // 2 < 5 -> pop 5
    // width = 2 -> area = 10 (max so far)
    // push 4 -> [1,4]
    // i = 5 -> height = 3 -> push -> [1, 4, 5]
    // i = 6 -> height = 0 (fake end)
    // pop all remaining:
    // compute remaining areas
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
