package LeetCode875;

/**
 * Solution for LeetCode 875
 *
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas/">LeetCode 875</a>
 * Time complexity: O(N Log(M)) Where N is the number of piles and M is the maximum value in piles
 * Space complexity: O(1)
 */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }

        return hours <= h;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] piles1 = {3, 6, 7, 11};
        System.out.println("Min speed: " + solution.minEatingSpeed(piles1, 8));

        int[] piles2 = {30, 11, 23, 4, 20};
        System.out.println("Min speed: " + solution.minEatingSpeed(piles2, 5));

        int[] piles3 = {30, 11, 23, 4, 20};
        System.out.println("Min speed: " + solution.minEatingSpeed(piles3, 6));

        int[] piles4 = {312884470};
        System.out.println("Min speed: " + solution.minEatingSpeed(piles4, 968709470));

        int[] piles5 = {1, 1, 1, 1};
        System.out.println("Min speed: " + solution.minEatingSpeed(piles5, 4));
    }
}
