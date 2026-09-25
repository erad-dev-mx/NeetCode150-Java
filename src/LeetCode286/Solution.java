package LeetCode286;

class Solution {
    // -1 means there is an obstacle => W
    // 0 means there is a gate => G
    // INF means there is empty room => E
    // | E | W | G | E |
    // | E | E | E | W |
    // | E | W | E | W |
    // | G | W | E | E |
    // This is going to be our answer
    // | 3 | W | G | 1 |
    // | 2 | 2 | 1 | W |
    // | 1 | W | 2 | W |
    // | G | W | 3 | 4 |
    // If there is no way to reach a G we turn that cell into INF

    // To solve if we keep iterating in every single E it could take a lot of time
    // It would be better to start from a certain point and then starting to branching
    // We will run through the matrix and get positions of Gs
    // From that Gs we start the branching
    // Since we can have multiple G pointing to a same E we will mark the number of distance
    // Why? In order to always have the smallest
    // We are using BFS + Queue
    public void wallsAndGates(int[][] rooms) {

    }
}
