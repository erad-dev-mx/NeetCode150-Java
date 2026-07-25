package LeetCode1046;

class Solution {
    // [2, 7, 4, 1, 8, 1, 3]
    // heaviest = 8,7 => 8 - 7 = 1
    // [2, 4, 1, 1, 1, 3]
    // heaviest = 4 - 3 = 1
    // [2, 1, 1, 1, 1]
    // heaviest = 2 - 1 = 1
    // [1, 1, 1, 1]
    // heaviest = 1 - 1 = 0
    // [1, 1]
    // heaviest = 1 - 1 = 0
    // return 0;

    // [6,8,3,4] => [2,3,4] => [2,1] => [1] => return 1;

    // PriorityQueue (MaxHeap)
    // We iterate putting each character in our new array
    // All the elements will be in ascending order
    // If top 2 are same size, destroy both them and move forward
    // If not, we calculate delta and put back the difference in our Heap
    public int lastStoneWeight(int[] stones) {
        Pro
    }
}