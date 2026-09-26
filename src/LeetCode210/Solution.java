package LeetCode210;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    // courses: [0, 1, 2, 3]
    // preReq: [[1,0], [2,1], [3,2]]
    // 0 -> 1 -> 2 -> 3 then we can return this as our answer
    // c: [[1,0], [2,1], [0,2]]
    // 0 -> 1 -> 2 -> 0 then we cannot complete all the courses no return []

    // To solve we will use Graph Theory (so we need nodes and edges)
    // As nodes we use number of courses and for edges we use the values inside preReq
    // c: 1, 2, 3, 4 - preReq: [1,0], [2,1], [3,2]
    // (0) --> (1) --> (2) --> (3)
    // Now we use DFS and try not to detect a cycle
    // We need to keep track of all visited nodes
    // To represent the graph we will use HashMap. As key, we have # of courses and as value preReq

    // How do we traverse? DFS
    // Find cycles? HashSet
    // Track? Stack, we will add values once we visite them, at the end should be full and the top of the stack
    // we should have a value with no preReq

    // It is very important to remember this thing: in order to finish courses we don't need to do it when
    // they are connected

    static int WHITE = 1;
    static int GRAY = 2; // During DFS it has been visited
    static int BLACK = 3; // Is in stack

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.init(numCourses);

        // Create graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed then call dfs on it
        for (int i = 0; i < numCourses; i++) {
            if (this.color.get(i) == WHITE) this.dfs(i);
        }

        int[] order;
        if (this.isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = this.topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<>();
        this.adjList = new HashMap<>();
        this.topologicalOrder = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    private void dfs(int node) {
        if (!this.isPossible) return;

        this.color.put(node, GRAY);
        for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<>())) {
            if (this.color.get(neighbor) == WHITE) {
                this.dfs(neighbor);
            } else if (this.color.get(neighbor) == GRAY) {
                this.isPossible = false;
            }
        }

        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }
}