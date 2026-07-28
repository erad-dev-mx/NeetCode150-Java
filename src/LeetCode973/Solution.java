package LeetCode973;

import java.util.PriorityQueue;

class Solution {
    // Brute force
    // We can simply start by calculating and then we will sort an find what is the K closest value
    // Optimal
    // We are going to use a MaxHeap with K length
    // We will keep tracking the K closests value
    // Time = O (n * log n)
    // Space = O (k)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}