package LeetCode74;

/**
 * Solution for LeetCode 74
 *
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix/">LeetCode 74</a>
 * Time complexity: O(Log(M * N))
 * Space complexity: O(1)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; // rows
        int n = matrix[0].length; // cols

        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n]; // Convert 1D index to 2D coordinates: row = mid / n, column = mid % n

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

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] m1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        System.out.println("Found: " + solution.searchMatrix(m1, 3));

        int[][] m2 = {
                {1, 3}
        };
        System.out.println("Found: " + solution.searchMatrix(m2, 3));

        int[][] m3 = {
                {1},
                {3}
        };
        System.out.println("Found: " + solution.searchMatrix(m3, 2));

        int[][] m4 = {
                {1, 2, 3, 4}
        };
        System.out.println("Found: " + solution.searchMatrix(m4, 4));
    }
}
