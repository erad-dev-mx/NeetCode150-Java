package LeetCode295;

import java.util.PriorityQueue;

// Basically, we will calculate the median
// (1,2,5,11,15,16) -> even -> 16/2 = 8
// (1,2,5,8,9) -> odd -> 5
// (1,5,8,3,15) -> (1,3,5,8,15) -> 5

// [findMedian]; DataStream[] -> return null
// [..., addNum(5)]; DataStream[5]
// [..., addNum(6)]; DataStream[5,6]
// [..., addNum(2)]; DataStream[5,6,2]
// [findMedian];  DataStream[5,6,2] -> return 5

// We receive an Item 1 at a time. We can use MinHeap (PriorityQueue) in addNum.
// To findMedian, despite having all the values inside one Heap, we can break the it in two portions
// We will have a [ MaxHeap {*] MinHeap }
// Every single element inside MaxHeap has to be smaller than every element inside MinHeap
// We will try to make the length similar
// If in DataStream values are even -> Average of two heaps is the answer
// If in DataStream values are odd -> We return max element in MaxHeap

// [52,2,3,5,11,7] => Max:[52], Min[] -- Then we check size difference (it should be less or equal to 1)
// [3,5,11,7] => Max:[2], Min[52]
// [5,11,7] => Max:[3,2], Min[52]
// [11,7] => Max:[3,2], Min[5,52]
// [7] => Max:[11,3,2], Min[5,52]
// Max:[5,3,2], Min[7,11,52]
// Return answer 5 + 7 / 2 = 12 / 2 = 6
class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {}
    
    public void addNum(int num) {
        maxHeap.offer(num); // Add to MaxHeap
        minHeap.offer(maxHeap.poll()); // Balancing step

        if (maxHeap.size() < minHeap.size()) maxHeap.offer(minHeap.poll()); // Maintain size property
    }
    
    public double findMedian() {
        return maxHeap.size() > minHeap.size() ? maxHeap.peek() : (maxHeap.peek() + minHeap.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */