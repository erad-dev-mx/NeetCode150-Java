package LeetCode226.Review;

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
public class ReviewV2 {
    // In order to dolve this problem
    // We should swap right child with left child
    // [1,2,3,4,5,6,7]
    // [1,3,2,4,5,6,7]
    // [1,3,2,7,6,4,5]
    // [1,3,2,7,6,5,4] => This is the answer
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
    }
}
