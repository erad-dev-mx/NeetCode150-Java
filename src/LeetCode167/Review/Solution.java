package LeetCode167.Review;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return null;
    }
}

// My thoughts: To solve we will use a two-pointer technique, because it is O(n) in time complexity. It works quite
// straightforward, we will add both value if the result is greater than target we will decrease the value of our right
// pointer if is less than target we will increase the value of left pointer.