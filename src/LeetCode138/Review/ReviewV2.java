package LeetCode138.Review;

/*
// Definition for a Node.
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
*/

// When we copy we need to avoid cycles
// Rather than treating as a LinkList problem we should treat as a Graph one
// Using DFS
// [[7,null],[15,3],[13,1],[10,2] ... Visited[]
// 1. DFS(Node 7):
//    - Not in visitedNode -> Create Copy(7')
//    - visitedNode = {7: 7'}
//    - 7'.next = DFS(Node 13) ---------------------> (Go deeper)
// 2. DFS(Node 13):
//    - Not in visitedNode -> Create Copy(13')
//    - visitedNode = {7: 7', 13: 13'}
//    - 13'.next = DFS(Node 11) --------------------> (Go deeper)
// 3. DFS(Node 11):
//    - Not in visitedNode -> Create Copy(11')
//    - visitedNode = {..., 13: 13', 11: 11'}
//    - 11'.next = DFS(Node 10) ...
//    - 11'.random = DFS(Node 1) (Assume 1 is further down)
// [HOW CYCLES ARE HANDLED]:
// When DFS(Node 1).random calls DFS(Node 7):
// - visitedNode.containsKey(7) is TRUE.
// - Returns existing Copy(7') immediately.
// - This "closes" the graph loop without infinite recursion.
// Final Map State: {OriginalNode : CopiedNode}
class ReviewV2 {
    public Node copyRandomList(Node head) {

    }
}
