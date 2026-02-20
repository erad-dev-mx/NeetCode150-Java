package LeetCode76.Review;

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
    }
}
