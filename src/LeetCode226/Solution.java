package LeetCode226;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Solution for LeetCode 226
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">LeetCode 226</a>
 * Time complexity: O(N)
 * Space complexity: O(H)
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        //        4
        //      /   \
        //     2     7
        //    / \   / \
        //   1   3 6   9
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9))
        );

        Solution solution = new Solution();
        TreeNode inverted = solution.invertTree(root);

        printLevelOrder(inverted);
    }

    private static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }
}