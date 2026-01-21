package LeetCode125.Review;

public class ReviewV2 {
    // Alphanumeric characters [a-z, A-Z, 0-9]
    // Two pointers: left, right
    // s = "A man, a plan, a canal: Panama"

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

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;

            left++;
            right--;
        }

        return true;
    }
}
