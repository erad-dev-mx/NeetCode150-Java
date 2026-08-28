package LeetCode79;

// [P,E,S,P,I]
// [T,S,M,A,Y]
// [E,P,I,D,B]
// [R,B,R,E,O]
// word = SPIDER
// We will start in m1 x n1 and there we will check if "S" is present
// If we found we will change the value temporary as a "#".
// Keeping moving we found "SPI" but since "I" doesn't have a neighbor we
// backtrack removing "#" symbols and we move forward trying to find the word.
// We are able to reach to thw word hence we return true.
// Time : O(N < 3^L), Space = O(L)
class Solution {
    public boolean exist(char[][] board, String word) {
       
    }
}
