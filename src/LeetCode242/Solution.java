package LeetCode242;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isAnagram("anagram", "nagaram")); // true
        System.out.println(solution.isAnagram("rat", "car")); // false
        System.out.println(solution.isAnagram("listen", "silent")); // true
        System.out.println(solution.isAnagram("hello", "world")); // false
        System.out.println(solution.isAnagram("", "")); // true
    }
}