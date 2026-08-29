package LeetCode131;

import java.util.List;

// s = a,b,c
// [a,b,c] -- in this case just values alone are palindrome

// s1 = a,a,b
// [a,a,b][aa,b]

// We will use backtracking to go to all the possibilities
//                  [a,a,b]
//             a                    aa              aab -x
//        a         ab -x       b -v
//  b -v
// [a,a,b][aa,b]
// When we found that there is a partition that is not palindrome we stop looking down
class Solution {
    public List<List<String>> partition(String s) {
        
    }
}