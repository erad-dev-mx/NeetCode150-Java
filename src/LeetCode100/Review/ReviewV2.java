package LeetCode100.Review;

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
    // Approach 1
    // Input: p = [1,2,3], q = [1,2,3]; Output = true
    // We traverse both arrays comparing two elements
    // If we found differences return false
    // If not, return true
    // Input: p = [1,2], q = [1,null,2]; Output = false
    // A very good way to solve is using recursion
    // First, checking all left subtrees and then, the right subtree
    // Time = O(N), Space = O (long n)
    public boolean isSameTree(TreeNode p, TreeNode q) {

    }
}
