package LeetCode141;

/**
 * Solution for LeetCode 141
 *
 * @see <a href="https://leetcode.com/problems/linked-list-cycle/">LeetCode 141</a>
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null || fast != null) {
            if (fast == null || fast.next == null) {
                return false;
            }

            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

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
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}