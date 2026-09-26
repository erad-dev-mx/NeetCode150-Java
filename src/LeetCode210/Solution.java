package LeetCode210;

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
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
    }
}