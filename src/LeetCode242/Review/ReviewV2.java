package LeetCode242.Review;

public class ReviewV2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] frequencyMap = new int[26];

        for (int i = 0; i < s.length(); i++) {
            frequencyMap[s.charAt(i) - 'a']++;
            frequencyMap[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < frequencyMap.length; i++) {
            if (frequencyMap[i] != 0) return false;
        }

        return true;
    }
}
