package LeetCode125;

/**
 * Solution for LeetCode 125
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">LeetCode 125</a>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 * This approach uses two pointers technique
 */

class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] inputs = {"", "a", "A man, a plan, a canal: Panama", "race a car", ".,!@#$", "MadAm", "12321", "12345"};

        for (String input : inputs) {
            boolean result = solution.isPalindrome(input);
            System.out.println("Input: \"" + input + "\" -> " + result);
        }
    }
}
