package LeetCode4.Review;

public class ReviewV2 {
    // Using Brute Force: We combine sorted array
    // Big(o) => O(m + n)

    // Time Complexity: O(log(min(m, n)))
    // x: [0, 3, 5, 6, 11] (len=5)
    // y: [1, 2, 8, 12, 13, 15] (len=6)
    // totalElements = 11 (Odd)
    // leftHalfSize = (5 + 6 + 1) / 2 = 6
    // Iteration 1:
    // start = 0, end = 5 -> partX = 2, partY = 6 - 2 = 4
    // LEFT:  x[0,3] (max=3),  y[1,2,8,12] (max=12)
    // RIGHT: x[5,6,11] (min=5), y[13,15] (min=13)
    // Check: 3 <= 13 (OK), but 12 > 5 (Too high!). Move start = partX + 1 = 3
    // Iteration 2:
    // start = 3, end = 5 -> partX = 4, partY = 6 - 4 = 2
    // LEFT:  x[0,3,5,6] (max=6), y[1,2] (max=2)
    // RIGHT: x[11] (min=11), y[8,12,13,15] (min=8)
    // Check: 6 <= 8 (OK), 2 <= 11 (OK). Found it!
    // Median: Math.max(xLeft, yLeft) = Math.max(6, 2) = 6.0
    // x: [1, 3, 8, 9] (len=4)

    // y: [7, 11, 18, 19, 21, 25] (len=6)
    // totalElements = 10 (Even)
    // leftHalfSize = (4 + 6 + 1) / 2 = 5
    //
    // Iteration 1:
    // start = 0, end = 4 -> partX = 2, partY = 5 - 2 = 3
    // LEFT:  x[1,3] (max=3), y[7,11,18] (max=18)
    // RIGHT: x[8,9] (min=8), y[19,21,25] (min=19)
    // Check: 3 <= 19 (OK), but 18 > 8 (Too high!). Move start = partX + 1 = 3
    //
    // Iteration 2:
    // start = 3, end = 4 -> partX = 3, partY = 5 - 3 = 2
    // LEFT:  x[1,3,8] (max=8), y[7,11] (max=11)
    // RIGHT: x[9] (min=9), y[18,19,21,25] (min=18)
    // Check: 8 <= 18 (OK), 11 <= 9 (Wait, 11 > 9!). Move start = partX + 1 = 4
    //
    // Iteration 3:
    // start = 4, end = 4 -> partX = 4, partY = 5 - 4 = 1
    // LEFT:  x[1,3,8,9] (max=9), y[7] (max=7)
    // RIGHT: x[] (min=INF), y[11,18,19,21,25] (min=11)
    // Check: 9 <= 11 (OK), 7 <= INF (OK). Found it!
    // Median: (max(9, 7) + min(INF, 11)) / 2 = (9 + 11) / 2 = 10.0
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    }
}
