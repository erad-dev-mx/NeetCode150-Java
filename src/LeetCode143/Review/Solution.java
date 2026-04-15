package LeetCode143.Review;

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
class Solution {
    // (1) -> (2) -> (3) -> (4) -> (5) -> (6) -> null
    // First LL: (1) -> (2) -> (3) -> (4) -> (5) -> (6)
    // Second LL: (4) -> (5) -> (6)
    // Second LL: (6) -> (5) -> (4) -> null HERE WE SWAP THE ORDER
    // Merge LL: (1) -> (6) -> (2) -> (5) -> (3) -> (4)
    // To get middle we create two pointers: slow and pointers
    // slow += 1, fast += 2
    // To reverse second linked list
    // (4) -> (5) -> (6)
    // 1. Store next: temp = curr.next
    // 2. Reverse link: curr.next = prev
    // 3. Move prev: prev = curr
    // 4. Move curr: curr = temp
    // Result: prev points to (6), which is the head of the reversed half.
    // Then, merge both LinkedList
    public void reorderList(ListNode head) {
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }