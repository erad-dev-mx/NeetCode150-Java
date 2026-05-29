package LeetCode235.Review;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    // root = [6, 3, 8], p = 6, q = 8, LCA = ?
    // We found 6 so we can immediately return 6 as our answer
    // root = [8, 3, 11, null, null, 9, null], p = 11, q = 9, LCA = ?
    // We start with 8, we compare with p & q. p & q are greater so we will search in right side of the subtree.
    // Immediately we return 11.
    // root = [3, 1, 5, null, null, 4, null], p = 3, q = 1, LCA = ?
    // We find a match with 3, so immediately we return as our answer.
    // root = [5, 3, 7, 1, null, 6, 11, null, null, 9, 13], p = 6, q = 9, LCA = ?
    // The root value (5) is less than 6 & 9 so we focus in right side of subtree, then if we compare 7. p is less than
    // 7 but q is greater. We return 7 as our answer.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}