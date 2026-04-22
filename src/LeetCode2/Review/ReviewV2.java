package LeetCode2.Review;

public class ReviewV2 {
    // l1 = (8) -> (0) -> (7)
    // l2 = (3) -> (0) -> (5)
    // var carry = 0
    // dummy = (1) -> () -> () --- carry = 1
    // dummy = (1) -> (1) -> () --- carry = 0
    // dummy = (1) -> (1) -> (2) --- carry = 1
    // dummy = (1) -> (1) -> (2) -> (1) --- carry = 0
    // Ans = 1211
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ans = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;

            ans.next = new ListNode(sum % 10);
            ans = ans.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
