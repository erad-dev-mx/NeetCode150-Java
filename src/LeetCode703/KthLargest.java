package LeetCode703;

import java.util.PriorityQueue;

// k = 3, nums = [4, 5, 8, 2]
// We will use Min-Heap (PriorityQueue) with k length
// The root (peek) always contains kth largest element
// kthLargest(int k, int[] nums)
// num = 4 -> heap: [4] (length < 3)
// num = 5 -> heap: [4, 5] (length < 3)
// num = 8 -> heap: [4, 5, 8] (length == 3)
// num = 2 -> 2 <= heap.peek(4) -> ignore
// Final initial heap [4, 5, 8], return null
// add(int val)
// add(3) -> 3 <= 4 (peek) -> ignore. Heap: [4, 5, 8] -> return 4
// add(5) -> 5 > 4 (peek)  -> poll(4), push(5). Heap: [5, 5, 8] -> return 5
// add(10)-> 10 > 5 (peek) -> poll(5), push(10). Heap: [5, 8, 10]-> return 5
// add(9) -> 9 > 5 (peek)  -> poll(5), push(9). Heap: [8, 9, 10] -> return 8
// add(4) -> 4 <= 8 (peek) -> ignore. Heap: [8, 9, 10] -> return 8
// ans = [null, 4, 5, 5, 8, 8]
class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */