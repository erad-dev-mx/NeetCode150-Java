package LeetCode131;

import java.util.ArrayList;
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
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(result, current, s, end + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}