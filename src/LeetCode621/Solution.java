package LeetCode621;

class Solution {
    // task = [A, B, A], n = 2
    // A -> B -> idle -> A ... return 4
    // task = [A, A, B, A], n = 2
    // A -> B -> idle -> A -> idle -> idle -> A ... return 7
    // Brute Force: We go to each task and compare in order to have the answer

    // task = [A, A, A, B, B], n = 2
    // FM = A - 3, B - 2
    // H = [3, 2]
    // We will create a kind of Frequency Map
    // Then we create a Heap with the frecuencies in descending order
    // Next we will mark the scenarios based on (n + 1)
    // Initial Heap = [3, 2]
    // Pop -> [3, 2]
    // Remaining frequencies -> [2, 1]
    // Heap after reinserting -> [2, 1]
    // intervals = 3
    // Pop -> [2, 1]
    // Remaining frequencies -> [1]
    // Heap after reinserting -> [1]
    // intervals = 6
    // Pop -> [1]
    // Heap becomes empty
    // intervals = 7 ... return 7
    public int leastInterval(char[] tasks, int n) {
        
    }
}