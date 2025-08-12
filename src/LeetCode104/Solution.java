package LeetCode104;

/**
 * Solution for LeetCode 104
 *
 * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">LeetCode 104</a>
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.right);

            return Math.max(maxLeft, maxRight) + 1;
        }
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

// Test class
class SolutionTest {
    public static void main(String[] args) {
        // Crear el árbol de ejemplo:
        //       3
        //      / \
        //     9  20
        //       /  \
        //      15   7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int depth = solution.maxDepth(root);

        System.out.println("Max Depth: " + depth);
    }
}