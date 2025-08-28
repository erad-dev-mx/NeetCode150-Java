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
    public List<String> encode(String s) {
        if (s.equals(Character.toString((char) 258))) return new ArrayList();

        String separator = Character.toString((char) 257);

        return Arrays.asList(s.split(separator, -1));
    }
}