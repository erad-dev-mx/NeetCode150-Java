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

// My thoughts: To solve this problem in just one run, it is necessary to implement a two-pointer approach with a front
// pointer and a back pointer. So first we create a dummy node before the start of the list to simplify the cases where
// the head is eliminated. Then we will move our front pointer (n + 1), with  this we will create a distance between
// both pointers. At the same time we will move our pointer until front pointer reaches to the end of the list (null).
// Finally, we will remove the reference to the eliminated node and we will return the head.