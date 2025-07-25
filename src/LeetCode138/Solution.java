package LeetCode138;

import java.util.HashMap;

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