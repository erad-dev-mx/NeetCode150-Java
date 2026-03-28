package LeetCode875.Review;

public class ReviewV2 {
    // Input: piles = [3,6,7,11], h = 8
    // Output: 4
    // k = 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11
    // h = 27| 15| 10| 8 | 8 | 6 | 5 | 5 | 5 | 5  | 4
    // Brute force = Run through all h elements
    // Optimal = Do binary search in h elements
    // 1.- l = 1 -> 27, r = 11 -> 4, mid = 6 -> 6 so here 6 < 8 decrease speed
    // 2.- l = 1 -> 27, r = 5 -> 8, mid = 3 -> 10 so here 10 > 8 increase speed
    // 3.- l = 4 -> 8, r = 5 -> 8, mid = 4 -> 8 so here 8 = 8 we are in expected result
    // Just to be sure we check the prev position to see if it's the first 8
    public int minEatingSpeed(int[] piles, int h) {
    }
}
