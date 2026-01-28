package LeetCode42.Review;

public class ReviewV2 {
    // h = [0,1,0,2,1,0,1,3,2,1,2,1] => two pointers
    // l = 0, r = h.length - 1; mL = h[l], mR = h[r];
    // if (height[left] < height[right]), max between lM and current h[l], if (lM - h[l] > 0), ans++, left++
    // else, max between rM and cureent h[r], if (rM - h[r] > 0), ans++, right--
    // Time complexity = O(n), Space complexity = O(1)
    public int trap(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];

        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                if (maxLeft - height[left] > 0) answer = answer + maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                if (maxRight - height[right] > 0) answer = answer + maxRight - height[right];
                right--;
            }
        }

        return answer;
    }
}
