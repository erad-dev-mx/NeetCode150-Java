package LeetCode146.Review;

import java.util.HashMap;

// Logic: Combining HashMap (O(1) access) + Doubly Linked List (O(1) reordering)
// Time Complexity: O(1) for both get and put
// Space Complexity: O(capacity) to store nodes and map entries
// STRUCTURE:
// [Head] <-> [Node (Most Recent)] <-> [Node (Least Recent)] <-> [Tail]
// - Dummy Head & Tail: Avoid null checks during insertion/deletion.
// - Map: Stores {Key : NodeReference} for instant access.
// DRY-RUN: Capacity = 2
// 1. put(1, 1):
//    Map: {1: Node1}, List: [Head] <-> [1] <-> [Tail]
// 2. put(2, 2):
//    Map: {1: Node1, 2: Node2}, List: [Head] <-> [2] <-> [1] <-> [Tail]
//    *Note: New nodes always go to Head (Most Recent).
// 3. get(1):
//    - Found in Map.
//    - Action: remove(Node1) -> insertAtHead(Node1)
//    List: [Head] <-> [1] <-> [2] <-> [Tail]
//    *Note: Node 1 is now Most Recent again.
// 4. put(3, 3):
//    - Capacity full!
//    - Evict: tail.prev (Node 2)
//    - Map.remove(2), remove(Node2)
//    - Insert Node 3 at Head.
//    List: [Head] <-> [3] <-> [1] <-> [Tail]
class LRUCacheReviewV2 {
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCacheReviewV2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    // Helper methods
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */