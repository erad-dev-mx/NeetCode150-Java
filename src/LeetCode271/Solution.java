package LeetCode271;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for LeetCode 271 Encode and Decode Strings
 *
 * @see <a href="https://leetcode.com/problems/encode-and-decode-strings/">LeetCode 271</a>
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 * This approach uses a delimiter to encode and decode a list of strings.
 */

public class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return Character.toString((char) 258);
        }

        String separate = Character.toString((char) 257);

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(separate);
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(Character.toString((char) 258))) {
            return new ArrayList<>();
        }

        String separate = Character.toString((char) 257);
        return Arrays.asList(s.split(separate, -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// String encoded = codec.encode(strs);

// Test class
class Test {
    public static void main(String[] args) {
        Solution codec = new Solution();
        List<String> strs = Arrays.asList("hello", "world", "this", "is", "a", "test");
        String encoded = codec.encode(strs);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}