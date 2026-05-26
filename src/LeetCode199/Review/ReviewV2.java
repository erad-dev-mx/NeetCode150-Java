package LeetCode199.Review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // To solve this, we could use BFS
        // Starting in root, then put it in a queue
        // Go down to all the children, and again we put the values in the queue
        // Example: [1, 2, 3, 4, 5, null, 6, null, null, 7, null]
        // Q = [1] => [3, 2, 1] => [5, 4, 3, 2, 1] => [6, 5, 4, 3, 2, 1] = [7, 6, 5, 4, 3, 2, 1]
        // Ans = [1, 3, 6, 7]
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
                    // Add tha last node's value of each level to the result
                    if (i == levelSize - 1) result.add(currentNode.val);

                    // Add child nodes to the queue for the next level
                    if (currentNode.left != null) queue.add(currentNode.left);
                    if (currentNode.right != null) queue.add(currentNode.right);
                }
            }

            return result;
        }
}
