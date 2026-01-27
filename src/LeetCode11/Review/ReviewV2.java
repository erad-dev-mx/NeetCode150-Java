package LeetCode11.Review;

public class ReviewV2 {
    // Two pointer (start and end)
    // Get the width (start - end) and area (min(start, end) *  width)
    // In a max variable we calculate if area is greater than the max value so far
    // Then we check whether start is less or equal than end
    // If true, we move left++, else start--;
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int width = end - start;
            int area = Math.min(height[start], height[end]) * width;
            max = Math.max(max, area);

            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;
    }
}
