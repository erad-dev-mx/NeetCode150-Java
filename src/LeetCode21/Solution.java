package LeetCode21;

/**
 * Solution for LeetCode 21
 *
 * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">LeetCode 21</a>
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(1);
        ListNode merge = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        merge.next = (list1 != null) ? list1 : list2;

        return dummy.next;
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