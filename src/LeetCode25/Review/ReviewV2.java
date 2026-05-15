package LeetCode25.Review;

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
    // (1) -> (2) -> (3) -> (4) -> (5) -> null, k = 6
    // k is greater than our numbers presents, so we return the same list
    // (1) -> (2) -> (3) -> (4) -> (5) -> null, k = 2
    // (2) -> (1) -> (3) -> (4) -> (5) -> null
    // (2) -> (1) -> (4) -> (3) -> (5) -> null

    // How to perform the reverse operation?
    // head = (1) -> (2) -> (3) -> (4) -> null
    // newHead = null, ptrNode = head, nextNode = null
    // nextNode = ptrNode.next, ptr.next = newHead, newHead = ptrNode, ptrNode = nextNode
    // head = (1) [ptrNode] -> (2) [nextNode] -> (3) -> (4) -> null
    // newHead = (1)
    // head = (1) -> (2) [ptrNode] -> (3) [nextNode] -> (4) -> null
    // newHead = (2) -> (1)
    // head = (1) -> (2) -> (3)  [ptrNode] -> (4) [nextNode] -> null
    // newHead = (3) -> (2) -> (1) ... etc

    // To do an optimal solution we could use recursion - Time: O(n), Space: O(n)
    // If we want something better we could use iterative approach - Time (n), Space O(1)
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

    private ListNode reverseLinkedList(ListNode head, int k) {
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
