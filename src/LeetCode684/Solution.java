package LeetCode684;

class Solution {
    // edges = [[1,2],[1,3],[2,3]]
    // In these cases all are connected because there is a cycle that means is not a tree
    // If we removed [2,3] now we have a Tree
    // We removed the last one because the problem tells us to do that
    // To solve this problem we can use: DSU (Disjoint Set Union)
    // Allows to create a group of sets, if we provide different object it can show us
    // to which group is part of.
    // find - which group is part of
    // merge - merge different groups into one common
    // DSU help us find cycles inside Undirected Graphs

    // To solve the above example we can create 4 groups
    // We create four groups base on nodes, parent[1,2,3,4]
    // Now we are going to work with edges
    // [1,4]: For 1 and 4 both parents are themselves so we do merge and, we choose 1 as parent.
    // parent:(1,2,3,1)
    // [1,2]: For 1 and 2 again we merge them establishing s link between them
    // parent: (1,1,3,1) ---> (1,1,1,1) ---> [2,3]: Now we will se there are common parents
    // So now we will return that edge as our answer
    public int[] findRedundantConnection(int[][] edges) {
        
    }
}