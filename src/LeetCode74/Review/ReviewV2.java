package LeetCode74.Review;

public class ReviewV2 {
    // Brute force: using loops but since we need O(log(m *n)) this is not possible
    // Binary Search
    // matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    // middle = 12 / 2 = 6; val at index 6 = 11
    // middle < target = 6 < 3 ? no : right = middle - 1
    // matrix = [[1,3,5,7],[10,11]], target = 3
    // middle = 6 / 2 = 3
    // middle < target = 5 < 3 ? no : right = middle - 1
    // matrix = [[1,3]
    // middle = 2 / 2 = 1
    // middle < target = 1 < 3 : left = middle + 1
    // middle == target
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int midValue = matrix[middle / cols][middle % cols];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}
