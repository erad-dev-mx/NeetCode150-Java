package LeetCode138.Review;

import java.util.HashMap;

// https://leetcode.com/problems/copy-list-with-random-pointer/

class Solution {

    HashMap<Node, Node> visitedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        if (this.visitedNode.containsKey(head)) return this.visitedNode.get(head);

        Node node = new Node(head.val);
        this.visitedNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}

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

// My thoughts: The solution uses a HashMap to remember which nodes have already been copied, so the program does not
// copy the same node twice and does not enter an infinite loop. The method works by checking if the current node is
// null, then checking if it was already copied, and if not, it creates a new node with the same value. After that, it
// copies the next and random pointers using recursion. In the end, it returns a new list that is a full and correct
// copy of the original.