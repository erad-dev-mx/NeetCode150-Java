package LeetCode25;

/**
 * Solution for LeetCode 25
 *
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">LeetCode 25</a>
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head;
        ListNode ktail = null;
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

                if (newHead == null) {
                    newHead = revHead;
                }

                if (ktail != null) {
                    ktail.next = revHead;
                }

                ktail = head;
                head = ptr;
            }
        }

        if (ktail != null) {
            ktail.next = head;
        }

        return newHead == null ? head : newHead;

    }

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