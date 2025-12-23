package LeetCode235;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if (pVal > parentVal && qVal > parentVal) return lowestCommonAncestor(root.right, p, q);
        if (pVal < parentVal && qVal < parentVal) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// My thoughts: One very important property of a binary search tree, is that the left node of a root is always less, and
// everything in the right is greater than that. Based on the previous property we can solve this problem comparing both
// p and q values with root to see in which position do our recursive call.