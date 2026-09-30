package LeetCode323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// We will receive number of nodes and edges
// The goal is to return how many connected components we have
// To solve we need to work with them as Graphs
// We will use BFS + Queue + Visited nodes

// Node 0 = (0) (2) (1), Node 1 = (3) (5), Node 2 = (4) (6), Node 3 = (7)
// Q = [0], V = 0, Count = 1 --RunBFS--> Q = [0,1,2], V = 012, Count = 1 ---> After doing BFS we can clean Q.
// Q = [3], V = 0123, Count = 2 --RunBFS--> Q = [3,5], V = 01235, Count = 2 ---> After doing BFS we can clean Q.
// Q = [4], V = 012354, Count = 3 --RunBFS--> Q = [4,6], V = 0123546, Count = 3 ---> After doing BFS we can clean Q.
// Q = [7], V = 0123547, Count = 4 --RunBFS--> There are no neighbors ----> Simply return 4

// Time = O (v + e)
// Space = (v)
class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, visited, i);
                count++;
            }
        }

        return count;
    }

    private void bfs(List<List<Integer>> graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
