package LeetCode207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
        HashMap<Integer, List<Integer>> courseGraph = new HashMap<>();

        for (int[] pre : prerequisites) {
            if (courseGraph.containsKey(pre[1])) {
                courseGraph.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> nextCourses = new LinkedList<>();
                nextCourses.add(pre[0]);
                courseGraph.put(pre[1], nextCourses);
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++) {
            if (courseSchedule(currentCourse, visited, courseGraph) == false) return false;
        }
        return true;
    }

    private boolean courseSchedule(int course, HashSet<Integer> visited, HashMap<Integer, List<Integer>> courseGraph) {
        if (visited.contains(course)) return false;
        if (courseGraph.get(course) == null) return true;

        visited.add(course);
        for (int pre : courseGraph.get(course)) {
            if (courseSchedule(pre, visited, courseGraph) == false) return false;
        }

        visited.remove(course);
        courseGraph.put(course, null);

        return true;
    }
}