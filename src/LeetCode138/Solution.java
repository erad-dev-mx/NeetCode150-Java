package LeetCode138;

import java.util.HashMap;

/**
 * Solution for LeetCode 138
 *
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">LeetCode 138</a>
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Solution {
    HashMap<Node, Node> visitedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (this.visitedNode.containsKey(head)) {
            return this.visitedNode.get(head);
        }

        Node node = new Node(head.val);
        this.visitedNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}

// Definition for a Node
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}