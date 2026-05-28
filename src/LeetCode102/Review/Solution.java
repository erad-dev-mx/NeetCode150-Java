package LeetCode102.Review;

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
class Solution {
    // We will use BFS (Breadth First Search)
    //       (1)
    //    (2)    (3)
    // (4) (5) (6) (7)
    // 1.- [1]
    // 2.- [1], [2,3]
    // 3.- [1], [2,3], [4,5,6,7]
    public List<List<Integer>> levelOrder(TreeNode root) {
        
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