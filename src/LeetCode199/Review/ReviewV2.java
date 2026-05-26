package LeetCode199.Review;

import java.util.List;

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
    // To solve this, we could use BFS
    // Starting in root, then put it in a queue
    // Go down to all the children, and again we put the values in the queue
    // Example: [1, 2, 3, 4, 5, null, 6, null, null, 7, null]
    // Q = [1] => [3, 2, 1] => [5, 4, 3, 2, 1] => [6, 5, 4, 3, 2, 1] = [7, 6, 5, 4, 3, 2, 1]
    // Ans = [1, 3, 6, 7]
    public List<Integer> rightSideView(TreeNode root) {

    }
}
