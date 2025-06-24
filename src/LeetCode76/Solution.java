package LeetCode76;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode 76
 *
 * @see <a href="https://leetcode.com/problems/minimum-window-substring/">LeetCode 76</a>
 * Time Complexity: O(S + T)
 * Space Complexity: O(S + T)
 */

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size();
        int l = 0, r = 0;
        int create = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> subStringMap = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = subStringMap.getOrDefault(c, 0);
            subStringMap.put(c, count + 1);

            if (mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()) {
                create++;
            }

            while (l <= r && required == create) {
                c = s.charAt(l);
                if (ans[0] == -1 || ans[0] >= r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                subStringMap.put(c, subStringMap.get(c) - 1);
                if (mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()) {
                    create--;
                }
                l++;
            }
            r++;
        }

        if (ans[0] == -1) {
            return "";
        } else {
            return s.substring(ans[1], ans[2] + 1);
        }
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        String result1 = solution.minWindow(s1, t1);
        System.out.println("Result 1: " + result1);

        String s2 = "A";
        String t2 = "AA";
        String result2 = solution.minWindow(s2, t2);
        System.out.println("Result 2: " + result2);

        String s3 = "ABC";
        String t3 = "ABC";
        String result3 = solution.minWindow(s3, t3);
        System.out.println("Result 3: " + result3);

        String s4 = "aaflslflsldkabc";
        String t4 = "abc";
        String result4 = solution.minWindow(s4, t4);
        System.out.println("Result 4: " + result4);

        String s5 = "ab";
        String t5 = "abc";
        String result5 = solution.minWindow(s5, t5);
        System.out.println("Result 5: " + result5);
    }
}