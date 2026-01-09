package LeetCode49.Review;

import java.util.*;

public class ReviewV2 {

    // Can be null
    // English alphabet

    /**
     * abc:
     * int[26] => [0,0,0,0,0,0,0...]
     * [1,1,1,0,0,0,0...] => "|1|1|1|0|0|0|0"
     * HashMap<key, List<String>> => o(1)
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> anagrams = new HashMap<>();
        int[] frequencyArray = new int[26];

        for (String s : strs) {
            Arrays.fill(frequencyArray, 0);

            for (char c : s.toCharArray()) {
                frequencyArray[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append("|");
                sb.append(frequencyArray[i]);
            }

            String key = sb.toString();
            if (!anagrams.containsKey(key)) anagrams.put(key, new ArrayList<>());
            anagrams.get(key).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
