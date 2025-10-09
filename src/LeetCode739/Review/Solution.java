package LeetCode739.Review;

import java.util.Stack;

class Solution {
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

// My thoughts: We will use a Stack to keep track of each index from the temperatures array. So we will start running
// through the array if we found a warmer temperature we will simply do a substraction with the index and put the
// result in the answer. If we don't found we need to add the value to the stack until we found something that satisfied
// the condition.