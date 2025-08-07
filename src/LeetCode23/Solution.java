package LeetCode23;

import java.util.PriorityQueue;

/**
 * Solution for LeetCode 23
 *
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">LeetCode 23</a>
 * Time complexity: O(N Log n)
 * Space complexity: O(N)
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode list: lists) {
            while (list != null) {
                minHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        while (!minHeap.isEmpty()) {
            merge.next = new ListNode(minHeap.remove());
            merge = merge.next;
        }

        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Test class
class TestMergeKLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        Solution solution = new Solution();

        ListNode result = solution.mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}