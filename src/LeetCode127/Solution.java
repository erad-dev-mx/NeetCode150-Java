package LeetCode127;

import java.util.List;

class Solution {
    // beginWord: hit; endWord: cog
    // hit -> hot -> dot -> lot -> log -> cog [6]
    // hit -> hot -> dot -> dog -> cog [5]
    // We return 0 if no such sequence exists

    // Basically having a beginWord, an endWord and a wordList we are in a graph
    // We need to return the shortest path between the beginning and the end
    // We can BFS

    // b: hit, e: cog, l: [hot, dot, dog, lot, log, cog]
    // hit -> we need to do m x 26 combinations but since we have a dictionary we can do it fast
    // hit -> hot -> dot -> lot -> dog -> cog
    // In this fashion we got a min of 6
    // hit -> hot -> lot -> dog -> cog
    // In this fashion we got a min of 5
    // hit -> hot -> dot -> dog -> cog
    // In this fashion we got a min of 5 so our remains the same
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    }
}