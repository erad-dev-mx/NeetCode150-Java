package LeetCode125.Review;

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

// My thoughts: To solve this problem the better approach is using a two-pointer technique algorithm. With left and
// right pointers we will track the string from the beginning to the end, for left we will increase our pointer,
// otherwise we will decrease our right pointer, the only complexity is validating if current value is a valid
// character because we can receive symbols like commas, points, etc.