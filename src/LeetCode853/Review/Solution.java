package LeetCode853.Review;

import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2]; // Just to not forgot: n is number of rows and 2 number of cols

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
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

// My thoughts: To solve this problem the first thing we need to do is to calculate how much time do the car need to
// reach to end with this simple formula: target - position of car divided by speed of car. Having that we will order
// the 2D array and with that is going to be simple to know if there is a fleet. How to know if there is a fleet?
// If the number which is at the top of the fleet (not the top of al cars) is greater than the number that follows it
// means is going to be part of the same fleet, why? because it means that previous number is faster but is impossible
// to overrun.