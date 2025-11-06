package LeetCode143.Review;

// https://leetcode.com/problems/reorder-list/

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
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, temp;

        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head, second = prev;

        while (second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;

            temp = second.next;
            second.next = first;
            second = temp;
        }
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

// My thoughts: To solve this problem we will implement three big steps: 1: Find the middle of the LinkedList, how can
// we reach to the middle? With a slow-fast pointer approach, we will use two pointer the slow one will advance one
// forward and the other fast will advance two places; having the middle we will move to the 2: Reverse Second
// LinkedList, here we will reverse using a temp variable and changing the arrows of every tail, finally 3: It is
// necessary to create a one single List and, we will stop merging the arrays when the second arrives to the null one.