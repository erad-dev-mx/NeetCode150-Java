package LeetCode133;/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayList;
import java.util.List;

// We need to create an exact copy not reference the original one
// (1) - (2)
//  |     |
// (4) - (3)
// We start with 1, so we copy that, next we can either go to 2 or 4.
// We will go to 2, then 3 and finally we visit 4
// Since this is a connected graph, if we use recursion we need to check not to be in a loop.
// We could use a data structure to track if we already visited that value (some Hash structure).
// Hash Map => | OriginalNode | CloneNode |
// We check if we have entry 1, if not we create a clone node
// 2 doesn't exists, we also add, with 3 happens the same, for 4 again happens the same
// Now we check second neighboors, and we will not duplicate values.
// We applied BFS.

class Solution {
    public Node cloneGraph(Node node) {
        
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}