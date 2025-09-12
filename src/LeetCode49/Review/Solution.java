package LeetCode49.Review;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> ansMap = new HashMap<>();

        int count[] = new int[26];

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

// My thoughts: Using a kind of frequency map, we will evaluate which words belongs to an anagram. For each word we
// build a frequency map of 26 letters. That map is the key in a HashMap. Words with the same key go to the same list,
// meaning they are anagrams.