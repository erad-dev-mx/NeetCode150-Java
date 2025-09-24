package LeetCode76.Review;

import java.util.HashMap;
import java.util.Map;

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

// My thoughts: To solve the problem it was necessary to use a two pointer plus sliding window technique, we will use
// a HashMap to store the value and the quantity for example (A, B, C) -> {(A, 1), (B, 1), (C, 1)}. After that we will
// initiate our pointer, until we get the values from the first HashMap while in the loop we will add all these values
// in other HashMap, if we found a potential answer we will save in out answer array the length, the left and the right
// pointer to compare with the next valid value. So after we found one we move left pointer until the end. To move right
// pointer it is necessary to not found any values from first HashMap.