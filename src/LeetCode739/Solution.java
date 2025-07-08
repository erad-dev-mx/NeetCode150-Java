package LeetCode739;

import java.util.Stack;

/**
 * Solution for LeetCode 739
 *
 * @see <a href="https://leetcode.com/problems/daily-temperatures/">LeetCode 739</a>
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

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