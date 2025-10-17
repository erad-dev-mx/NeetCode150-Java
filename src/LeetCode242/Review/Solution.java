package LeetCode242.Review;

// https://leetcode.com/problems/valid-anagram/

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }

        return true;
    }
}

// My thoughts: We create a kind of frequency map with every letter of the alphabet. One string adds +1, the other
// string adds -1. At the end, if the map is not full of zeroes it means that is not an anagram.