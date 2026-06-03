package LeetCode98.ReviewV2;

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
class Solution {
    // (5)
    // (3)      (8)
    // (1) (4)  (2) (9)
    // We start with our root validating if values are lower and higher.
    // Until the end, but there is a problem. We will have a false positive in 8.
    // Why? 2 is less than 8 and 9 is greater than 8 but by definition everything on the right side should be
    // greater than 5 but in this case 2.
    // In Order Traversal: Left -> Node -> Right
    // (5)
    // (3)      (8)
    // (1) (4)  (6) (9)
    // Visiting the prev tree: 1, 3, 4, 5, 6, 8, 9
    // We will just check if the val + 1 is greater than val.
    // Traversal in first tree: 1, 3, 4, 5, 2 -> invalid, so we return false
    public boolean isValidBST(TreeNode root) {
        
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }