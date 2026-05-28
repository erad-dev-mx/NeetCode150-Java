package LeetCode102.Review;

import java.util.ArrayList;
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

    List<List<Integer>> answer  = new ArrayList<>();

    private void order(TreeNode node, int level) {
        if (answer.size() == level) answer.add(new ArrayList<Integer>());

        answer.get(level).add(node.val);

        if (node.left != null) order(node.left, level + 1);
        if (node.right != null) order(node.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return answer;

        order(root, 0);

        return answer;
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