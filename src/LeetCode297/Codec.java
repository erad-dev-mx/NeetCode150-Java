package LeetCode297;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// We need to traverse the ree, searialize into a string and then, back to tree
// To searialize tree, we use preOrder traversal with DFS: Root -> Left -> Right
//      (1)
//   (2)      (3)
// (4) (5)  null null
// s = 1, 2, 4, null, null, 5, null, null, 3, null, null
// To deserialize string
// s = 1, 2, 4, null, null, 5, null, null, 3, null, null
// Again using preOrder Traversal
//      (1)
//  (2)     (3)
// (4) (5)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}