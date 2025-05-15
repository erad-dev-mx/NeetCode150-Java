package LeetCode49;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/

// Time Complexity: O(N * K)
// Space Complexity: O(N * K)
// This approach uses a HashMap to group anagrams together.

class OptimalSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> ansMap = new HashMap<>();

        int[] count = new int[26];

        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();
            if (!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }
            ansMap.get(key).add(s);
        }
        return new ArrayList<>(ansMap.values());
    }
}

// Test class
class TestII {
    public static void main(String[] args) {
        OptimalSolution solution = new OptimalSolution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}