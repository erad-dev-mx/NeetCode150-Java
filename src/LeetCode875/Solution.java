package LeetCode875;

/**
 * Solution for LeetCode 875
 *
 * @see <a href="https://leetcode.com/problems/binary-search/">LeetCode 875</a>
 * Time complexity: O(N Log(M))WhereNIsTheNumberOfPilesAndMIsTheMaximumValueInPiles
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