package LeetCode19.Review;

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
    // Example: (1)->(2)->(3)->(4)->(5)->(6)
    // n = 2
    // 1st Iteration: (1[BP])->(2)->(3)->(4[FP])->(5)->(6)->null
    // 2nd Iteration: (1)->(2[BP])->(3)->(4)->(5[FP])->(6)->null
    // 3rd Iteration: (1)->(2)->(3[BP])->(4)->(5)->(6[FP])->null
    // 4th Iteration: (1)->(2)->(3)->(4[BP])->(5)->(6[FP])->null[FP]
    // FP is equal to null, then BP.next = BP.next.next
    // 5th Iteration: (1)->(2)->(3)->(4)->(6)->null[FP]
    public ListNode removeNthFromEnd(ListNode head, int n) {

    }
}
