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

// Test class
class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        printResult(temps1, solution.dailyTemperatures(temps1));

        int[] temps2 = {30, 40, 50, 60};
        printResult(temps2, solution.dailyTemperatures(temps2));

        int[] temps3 = {30, 60, 90};
        printResult(temps3, solution.dailyTemperatures(temps3));

        int[] temps4 = {90, 80, 70, 60, 50};
        printResult(temps4, solution.dailyTemperatures(temps4));

        int[] temps5 = {70, 71, 70, 71, 70};
        printResult(temps5, solution.dailyTemperatures(temps5));
    }

    private static void printResult(int[] input, int[] output) {
        System.out.print("Input:  ");
        printArray(input);
        System.out.print("Output: ");
        printArray(output);
        System.out.println();
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}