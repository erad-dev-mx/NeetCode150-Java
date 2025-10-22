package LeetCode74.Review;

// https://leetcode.com/problems/search-a-2d-matrix/c

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / cols][mid % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

// My thoughts: To solve this problem in the right way it is necessary to take advantage of the sorting 2D array. We can
// use the 2D array as a normal one because is order in non-decreasing order. The only key is to get the midValue.