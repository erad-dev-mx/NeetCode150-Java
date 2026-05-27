package LeetCode1448.Review;

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
    // We will use DFS
    // First, we will check root at any given position
    // Then, left entire subtree and right entire subtree
    // So we use Pre Order Traversal (Root, Left, Right)
    // We keep track of Max Value. In each Current Node we will evaluate if it is greater.
    // (3)
    // (1) (4)
    // (3) (5) null (3)
    // MV = 3, 1 is not a good node, 3 is a good node; count = 2, 5 is a good node; count = 3; there is no child so we
    // avoid updating MV.
    // MV = 3, 4 is a good node; MV = 4; count = 4, 2 is not a good node
    // We return 4
    public int goodNodes(TreeNode root) {
        
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