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


// Test class
class Test {
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Crear lista: 1 → 2 → 3 → 4 → 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();

        System.out.println("Original list:");
        printList(head);

        int k = 2;
        ListNode result = solution.reverseKGroup(head, k);

        System.out.println("After list:");
        printList(result);
    }
}