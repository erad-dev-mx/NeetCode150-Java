package LeetCode110.Review;

// https://leetcode.com/problems/balanced-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

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

// My thoughts: To determinate whether a binary tree is balance or not, we need to ensure that the height difference
// between left and right subtrees of every node is no more than 1. . To check this, we recursively compute the height
// of each subtree. For every node, we compare the heights of its left and right children; if the difference is greater
// than 1, the tree is not balanced. Otherwise, we continue checking the left and right subtrees. The getHeight function
// returns the height of a subtree, which is used to evaluate the balance condition at each node. Although this solution
// works, it has a drawback: heights are recomputed multiple times, resulting in O(n^2) complexity in the worst case.