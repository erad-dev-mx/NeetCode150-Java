package LeetCode141.Review;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null || fast != null) {
            if (fast == null || fast.next == null) return false;

            if (fast == slow) return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// My thoughts: To solve this problem using a O(1) in space complexity we will use a slow-fast algorithm, we will be
// jumping with slow pointer one by one, with fast pointer we are going to jump twice. If in a moment there are equal
// we will return true.