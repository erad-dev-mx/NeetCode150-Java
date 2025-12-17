package LeetCode1448;

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = 0;
        // Check if the current node is a good node
        if (node.val >= maxSoFar) {
            count = 1; // Current node is a good node
            maxSoFar = node.val; // Update the max value along the path
        }

        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
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

// My thoughts: To solve this problem we will use recursion and backtracking with DFS (Depth-First Search) a method used
// to explore all the nodes in a tree by going as deep as possible along each branch before moving to the next one. It
// starts at the root node and visits every node in the tree. With DFS, we can have a track of all the values to
// determinate if is a good node or not.