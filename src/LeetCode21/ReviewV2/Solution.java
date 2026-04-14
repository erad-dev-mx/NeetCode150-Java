package LeetCode21.ReviewV2;

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
    // l1 = (1), (2), (4)
    // l2 = (1), (3), (4)
    // Pointers[1,1] => m = (1) - (1)
    // Pointers[2,3] => m = (1) - (1) - (2)
    // Pointers[4,3] => m = (1) - (1) - (2) - (3)
    // Pointers[4,4] => m = (1) - (1) - (2) - (3) - (4) - (4)
    // Dummy will point to m head
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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