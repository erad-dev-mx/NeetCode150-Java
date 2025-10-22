package LeetCode875.Review;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for (int pile : piles) {
            right = Math.max(pile, right);
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

    private boolean canFinish(int[] piles, int speed, int h) {
        int hours = 0;
        for(int pile : piles) {
            hours += (int) Math.ceil((double) pile / speed);
        }

        return hours <= h;
    }
}