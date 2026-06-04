package LeetCode230;

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
    //      (5)
    //  (3)       (8)
    // (1) (4) null (8)
    // root = [5, 3, 8, 1, 4, null, 8]
    // If we traverse in this way: 1, 3, 4, 5, 8, 9
    // Now we can get easy the kth position
    // How to do that? With In Order Traversal (Left -> Node -> Right)
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    private ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);

        return arr;
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