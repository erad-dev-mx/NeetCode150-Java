package LeetCode110;

/**
 * Solution for LeetCode 110
 *
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">LeetCode 110</a>
 * Time complexity: O(N)
 * Space complexity: O(N)
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
        // Tree:
        //      3
        //     / \
        //    9  20
        //       / \
        //      15  7
        // Expected: true

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        boolean result = solution.isBalanced(root);
        System.out.println(result); // Expected: true
    }
}