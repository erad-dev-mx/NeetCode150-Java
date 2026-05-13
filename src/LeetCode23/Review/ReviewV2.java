package LeetCode23.Review;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ReviewV2 {
    // We can try using a PriorityQueue representing the MinHeap
    // l1 = 4, 7; l2 = 3, 8; l3 1, 18
    // minHeap = [4,7] => minHeap = [3,4,7,8] => minHeap = [1,3,4,7,8,18]
    // mergeList = 1,3,4,...
    // Time Complexity = O (n log n), Space Complexity = O (n)
    public ListNode mergeKLists(ListNode[] lists) {

    }
}
