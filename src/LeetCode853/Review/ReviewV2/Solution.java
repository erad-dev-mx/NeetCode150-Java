package LeetCode853.Review.ReviewV2;

class Solution {
    // Create a list of pairs (position, timeToTarget)
    // Sort the prev list by position in descending order
    // count = 0 and maxTimeNeeded = 0
    // For each car in the sorted list
    // - If car.time > maxTimeNeeded
    // --- This car is a new fleet leader
    // --- Increment count
    // --- Update maxTimeNeeded = car.time
    // Return count
    // target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
    // Car[0] = (12 - 10) / 2 = 1; Car[1] = (12 - 8) / 4 = 1
    // Car[2] = (12 - 0) / 2 = 12; Car[3] = (12 - 5) / 1 = 7
    // Car[4] = (12 - 3) / 2 = 3
    // [(10, 1), (8, 1), (5, 7), (3,3), (0, 12)]
    // Car at 10: count = 1, prevTime = 1; Car at 8: count = 1, time = 1 so 1 <= 1
    // Car at 5: count 1, time = 7 so 7 > 1; count = 2, prevTime = 7
    // Car at 3: count 2, time = 3 so 3 < 7; count = 2, prevTime = 7
    // Car at 0: count 2, time 12 so 12 > 7; count = 3, prevTime = 12
    // ANS = 3
    public int carFleet(int target, int[] position, int[] speed) {
        
    }
}