package LeetCode49;

import java.util.*;

// https://leetcode.com/problems/group-anagrams/

// Time Complexity: O(N * K log K)
// Space complexity: O(N * K)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars); // O(K log K)
            String key = new String(chars); // "eat" → "aet"

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
