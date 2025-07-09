package LeetCode853;

import java.util.Arrays;

/**
 * Solution for LeetCode 853
 *
 * @see <a href="https://leetcode.com/problems/car-fleet/submissions/">LeetCode 853</a>
 * Time complexity: O(N Log N)
 * Space complexity: O(N)
 */

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; // Position of the car
            cars[i][1] = (double) (target - position[i]) / speed[i]; // How much time does need to reach to destination
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int count = 0;
        double prevTime = 0;
        for (double[] car : cars) {
            if (car[1] > prevTime) {
                count++;
                prevTime = car[1];
            }
        }

        return count;
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int target1 = 12;
        int[] pos1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        System.out.println("Fleet count: " + solution.carFleet(target1, pos1, speed1));

        int target2 = 10;
        int[] pos2 = {3};
        int[] speed2 = {3};
        System.out.println("Fleet count: " + solution.carFleet(target2, pos2, speed2));

        int target3 = 100;
        int[] pos3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};
        System.out.println("Fleet count: " + solution.carFleet(target3, pos3, speed3));

        int target4 = 15;
        int[] pos4 = {6, 8};
        int[] speed4 = {3, 2};
        System.out.println("Fleet count: " + solution.carFleet(target4, pos4, speed4));
    }
}