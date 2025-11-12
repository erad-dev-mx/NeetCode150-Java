package LeetCode19.Review;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;

        ListNode frontPointer = dummy;
        ListNode backPointer = dummy;

        for (int i = 0; i <= n; i++) {
            frontPointer = frontPointer.next;
        }

        while (frontPointer != null) {
            frontPointer = frontPointer.next;
            backPointer = backPointer.next;
        }

        backPointer.next = backPointer.next.next;

        return dummy.next;
    }
}

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