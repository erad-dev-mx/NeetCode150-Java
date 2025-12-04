package LeetCode25.Review;

// https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ptr = head;
        ListNode kTail = null;
        ListNode newHead = null;

        while (ptr != null) {
            int count = 0;
            ptr = head;

            while (count < k && ptr != null) {
                ptr = ptr.next;
                count++;
            }
            if (count == k) {
                ListNode revHead = reverseLinkedList(head, k);

                if (newHead == null) newHead = revHead;

                if (kTail != null) kTail.next = revHead;

                kTail = head;
                head = ptr;
            }
        }

        if (kTail != null) {
            kTail.next = head;
        }

        return newHead == null ? head : newHead;
    }

    // Helper method
    public ListNode reverseLinkedList(ListNode head, int k) {
        ListNode newHead = null;
        ListNode ptr = head;

        while (k > 0) {
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;
            ptr = nextNode;

            k--;
        }

        return newHead;
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

// My thoughts: This problem is about reversing a linked list in groups of size k. We take the list and look at the
// first k nodes. If there are at least k nodes, we reverse these k nodes. Then we move to the next k nodes and do the
// same thing again. If the last group has fewer than k nodes, we do NOT reverse that part. The goal is to return the
// head of the modified list.