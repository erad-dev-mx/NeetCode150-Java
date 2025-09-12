package LeetCode42.Review;

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

// My thoughts: We use two pointers, one at the start and one at the end. We keep track of the highest bar from left and
// right. We move the pointer on the smaller side, because water depends on the lower max. If the current bar is lower
// than its max, we add trapped water, else update the max. We compare left and right because the smaller side is the
// limit, that side decides how much water can be trapped. Repeat until pointers meet, total is the trapped water.