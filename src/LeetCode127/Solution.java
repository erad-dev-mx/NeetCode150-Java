package LeetCode127;

import java.util.*;

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
        int L = beginWord.length();
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        Queue<LeetCode127.Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new LeetCode127.Pair<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            LeetCode127.Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) return level + 1;

                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new LeetCode127.Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}