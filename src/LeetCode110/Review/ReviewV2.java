package LeetCode110.Review;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class ReviewV2 {
    // We need to check, both heights from left and right subtrees
    // Recursion
    // Base case: current == 0
    // Recursive call: Traverse right child, then traverse left child
    // counter for both heights
    // Absolute Difference (leftHeigh - rightHeight) > 1 is INVALID
    // The Height Balance Tree
    public boolean isBalanced(TreeNode root) {
    }
}
