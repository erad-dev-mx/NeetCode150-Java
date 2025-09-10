package LeetCode11.Review;

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

// My thoughts: To solve this problem it is necessary to use a two-pointer technique. We are going to get the width
// with the minus operation between right and left. Then we are going to calculate area, multiplying the min value
// between left and right by width. Our pointers are moving depending on which value is greater than the other one.