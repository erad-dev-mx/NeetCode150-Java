package LeetCode105;

import java.util.HashMap;
import java.util.Map;

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
    //       (5)
    //   (3)     (8)
    // (1) (7) (6) (9)
    // PreOrder Traversal: Root -> Left -> Right - 5, 3 , 1, 7, 8, 6, 9
    // InOrder Traversal: Left -> Root -> Right - 1, 3, 7, 5, 6, 8, 9
    //      (5)
    // (3)          (8)
    // null null  (6)  (9)
    // PreOrder: 5, 3, 8, 6, 9
    // InOrder: 3, 5, 6, 8, 9
    // We can see PreOrder first value is the root, then we see left values from 5 in InOrder are left side
    // Ans: 5, 3, null, null
    // PreOrder now 8 is the root, we know the values around that number are left and right side
    // Ans: 5, 3, null, null, 8, 6, null, null, 9, null, null

    int preOrderIndex;
    Map<Integer, Integer> inOrderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        inOrderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preOrderIndex++];

        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inOrderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inOrderIndexMap.get(rootValue) + 1, right);

        return root;
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