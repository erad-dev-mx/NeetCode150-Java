package LeetCode207;

class Solution {
    // prerequisites = [[1,0],[0,3],[2,0]]
    // num = (0,1,2,3)
    // (1) -> (0) -> (3)
    // (2) -> (0)
    // In this example we can complete all courses
    // So we return true
    // Let's imagine that we add [3,2]
    // (1) -> (0) -> (3)
    // (2) -> (0)
    // (3) -> (2)
    // There is a kind of loop with 0, 2, 3 because there is dependency within them
    // So we return false
    // When we detect a loop immediately we can return false

    // We will use a graph DS, as a HashMap as a key we save number of courses
    // As a value we save number of pre-requisites
    // First we will start adding the value to the HashMap, once we finish we backtrack to check
    // How to validate? If value within the HM is empty that means we can return TRUE
    // The additional step to validate loops? We will use a HashSet and there we will keep track of visited
    // When we try to add a duplicate item that means we are in a loop
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
    }
}