package LeetCode875.Review;

// https://leetcode.com/problems/koko-eating-bananas/

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

// My thoughts: To avoid using a brute force approach we will use a binary search, but why? and how? Well if we take a
// range between 1 to the greatest number inside de pile we will see that if we create a kind of graphic, we will see
// that with 1 it is going to take us a lot of hours but if we see the latest numbers we will see that it takes us few
// hours. With this we can start doing a binary search through the piles, and we will compare if it is the number that
// satisfied our problem. To satisfy the problem, is necessary to complete all the piles in the 'h' hours, and also it
// has to be the less possibles bananas, image that 3 and 4 satisfied the problem our answer needs to be 3 because is
// less than 4.
// Why do we return 'left'? Well, during the binary search we are shrinking our search space from both sides. Every time
// 'canFinish' returns true, it means that the current speed (mid) is enough or maybe too fast, so we try to find a
// smaller one by moving 'right' to 'mid'. On the other hand, when 'canFinish' is false, it means the speed is too slow,
// and we need to move 'left' to 'mid + 1'. When the loop finishes, both 'left' and 'right' will point to the same value
// the smallest speed that still allows finishing all piles within 'h' hours. That’s why returning 'left' gives us
// the minimum valid eating speed.
// About the private function 'canFinish': This helper function checks if Koko can finish all the piles at a specific
// eating speed within 'h' hours. It goes through every pile and calculates how many hours it would take at that speed,
// using the ceiling because Koko can’t eat part of a pile in less than an hour. If the total hours are less than or
// equal to 'h', it returns true; otherwise false. This helps the binary search know whether to look for a smaller or
// bigger speed.