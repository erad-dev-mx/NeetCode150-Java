package LeetCode76.Review;

import java.util.HashMap;
import java.util.Map;

public class ReviewV2 {
    // s = "ADOBECODEBANC" t = "ABC"
    // targetMap: {A:1, B:1, C:1}, required: 3
    // windowMap: {}, create: 0, ans: [-1, 0, 0]
    // R=0 (A): windowMap: {A:1}, create: 1 (A completed) > R=1 (D): windowMap: {A:1, D:1}
    // R=2 (O): windowMap: {A:1, D:1, O:1} >  R=3 (B): windowMap: {A:1, D:1, O:1, B:1}, create: 2 (B completed)
    // R=4 (E): windowMap: {..., E:1} > R=5 (C): windowMap: {..., C:1}, create: 3 -> (ADOBEC)
    // ans = [6, 0, 5]

    // WHILE R < s.length:
    //  1. Add s[R] a windowMap.
    //  2. IF s[R] has frequence of targetMap: create++
    // WHILE create == required:
    //      1. IF actual_len < min_len: Update answer
    //      2. Remove s[L] from windowMap
    //      3. IF s[L] frequency is not the necessary: create--
    //      4. L++
    //  R++
    // RETURN substring(ans)

    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length()) return "";

        Map<Character, Integer> hashMapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMapT.put(t.charAt(i), hashMapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = hashMapT.size();
        int l = 0, r = 0;
        int create = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> subStringHashMap = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            int count = subStringHashMap.getOrDefault(c, 0);
            subStringHashMap.put(c, count + 1);
            if (hashMapT.containsKey(c) && subStringHashMap.get(c).intValue() == hashMapT.get(c).intValue()) {
                create++;
            }

            while (l <= r && required == create) {
                c = s.charAt(l);
                if (ans[0] == -1 || ans[0] >= r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                subStringHashMap.put(c, subStringHashMap.get(c) - 1);
                if (hashMapT.containsKey(c) && subStringHashMap.get(c).intValue() < hashMapT.get(c).intValue()) {
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
