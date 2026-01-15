package LeetCode271.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) return Character.toString((char) 258);

        String separator = Character.toString((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(separator);
        }
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(Character.toString((char) 258))) return new ArrayList();

        String separator = Character.toString((char) 257);

        return Arrays.asList(s.split(separator, -1));
    }
}

// My thoughts: In this problem we use characters 257 and 258 because the problem says that we are only using characters
// from 0 to 256. So for that we use 257 as a separator and 258 like a return because is not a valid character.
// It's a simple way to encode the string list into a single string a vice versa.