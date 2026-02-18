package LeetCode424.Review;

public class ReviewV2 {
    // Longest repeating character present in strins s
    // Sliding window + two pointers
    // windowLength = (right - left + 1)
    // maxOccurrence
    // windowLenght - maxOcurrence
    // Edge case: windowLength - maxOccurrence > k => this means our window is not a valid one
    // s = "AABABBA", k = 1 ---> left = 0, right = 0, window = [A], mO = 1
    // left = 0, right = 1, window = [AA], mO = 2 ---> left = 0, right = 2, window = [AAB], mO = 3
    // left  = 0, right = 3, window = [AABA], m0 = 3 ---> left = 0, right = 4, window = [AABAB], m0 = 3
    // 5 - 3 = 2 then k < 2
    public int characterReplacement(String s, int k) {
        int occurrence[] = new int[26];
        int left = 0;
        int answer = 0;
        int maxOccurrence = 0;

        for (int right = 0; right < s.length(); right++) {
            maxOccurrence = Math.max(maxOccurrence, ++occurrence[s.charAt(right) - 'A']);
            if (right - left + 1 - maxOccurrence > k) {
                occurrence[s.charAt(left) - 'A']--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
