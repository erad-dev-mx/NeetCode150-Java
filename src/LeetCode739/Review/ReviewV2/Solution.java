package LeetCode739.Review.ReviewV2;

import java.util.Stack;

class Solution {
    // [73,74,75,71,69,72,76,73]
    // i = 0 (73): Empty stack we push index 0 => stack = [0]
    // i = 1 (74): 74 > temp[stack.peek()] (74 > 73)? YES => Pop index 0. ans[0] = 1 - 0 = 1.
    // stack = [], then push index 1 => stack = [1], ans = [1, 0, 0, 0, 0, 0]
    // i = 2 (75): 75 > temp[1] (75 > 74)? YES => Pop index 1. ans[1] = 2 - 1 = 1.
    // stack = [], then push index 2. => stack = [2], ans = [1, 1, 0, 0, 0, 0]
    // i = 3 (71): 71 > temp[2] (71 > 75)? NO => Push index 3 => stack = [2, 3]
    // i = 4 (69): 69 > temp[3] (69 > 71)? NO => Push index 4 => stack = [2, 3, 4]
    // i = 5 (72): 72 > temp[4] (72 > 69)? YES => Pop index 4. ans[4] = 5 - 4 = 1.
    // 72 > temp[3] (72 > 71)? YES => Pop index 3. ans[3] = 5 - 3 = 2.
    // 72 > temp[2] (72 > 75)? NO => Push index 5.
    // stack = [2, 5], ans = [1, 1, 0, 2, 1, 0]
    // Final: [1, 1, 0, 2, 1, 0]
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        return answer;
    }
}