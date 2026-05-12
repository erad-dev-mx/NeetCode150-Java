package LeetCode146.Review;

// Logic: Combining HashMap (O(1) access) + Doubly Linked List (O(1) reordering)
// Time Complexity: O(1) for both get and put
// Space Complexity: O(capacity) to store nodes and map entries
// STRUCTURE:
// [Head] <-> [Node (Most Recent)] <-> [Node (Least Recent)] <-> [Tail]
// - Dummy Head & Tail: Avoid null checks during insertion/deletion.
// - Map: Stores {Key : NodeReference} for instant access.
// DRY-RUN Example: Capacity = 2
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

    public LRUCacheReviewV2(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */