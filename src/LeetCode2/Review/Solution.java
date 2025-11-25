package LeetCode2.Review;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;

            ans.next = new ListNode(sum % 10);
            ans = ans.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

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

// My thoughts: To solve this problem it is necessary to use a dummy list that will we point to the answer. Also, we
// will use a carry variable that will contain just 1 or 0 (because 9 + 9 + 1 is max 19). We start our while loop
// checking if l1 or l2 are not null and also check if carry is it different to 0. We will calculate the respective
// values of x and y, then we will sum both the values plus the carry. At the end, we will move the pointers.