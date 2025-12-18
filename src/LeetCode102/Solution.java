package LeetCode102;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return ans;

        order(root, 0); // Starting from root node at level 0

        return ans;
    }

    public void order(TreeNode node, int level) {
        if (ans.size() == level) ans.add(new ArrayList<>()); // this level does not exist yet so a new list is created
        ans.get(level).add(node.val); // adding value for that level

        // then we call recursively
        if (node.left != null) order(node.left, level + 1);
        if (node.right != null) order(node.right, level + 1);
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

// My thoughts: This code performs a level order traversal of a binary tree (Breadth-first search). It visits the tree
// level by level from top to bottom and left to right. The method levelOrder checks if the tree is empty and then
// starts a recursive traversal using the order method. The order method keeps track of the current level and creates a
// new list when a level is visited for the first time. Each node value is added to the list that represents its level,
// and the method recursively visits the left and right child nodes with an increased level. The final result is a list
// of lists, where each inner list contains the values of one level of the tree.