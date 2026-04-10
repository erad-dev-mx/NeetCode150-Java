package LeetCode206.Review;

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

// Head -> [1] -> [2] -> [3] -> NULL
// prev = NULL, curr = [1]
// temp = curr.next ([2]) - curr.next = prev (NULL) - prev = curr ([1]) - curr = temp ([2])
// State: NULL <- [1] (prev)   [2] (curr) -> [3] -> NULL
// temp = curr.next ([3]) - curr.next = prev ([1]) - prev = curr ([2]) - curr = temp ([3])
// State: NULL <- [1] <- [2] (prev)   [3] (curr) -> NULL
// temp = curr.next (NULL) - curr.next = prev ([2]) - prev = curr ([3]) - curr = temp (NULL)
// curr is NULL, loop ends.
// prev is at [3], which is the new head of the reversed list.
// Result: [3] -> [2] -> [1] -> NULL
class Solution {
    public ListNode reverseList(ListNode head) {
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}