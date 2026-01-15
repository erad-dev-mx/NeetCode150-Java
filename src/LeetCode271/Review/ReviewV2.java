package LeetCode271.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewV2 {
    // 0 - 256 characters
    // 257 and 258 as a separator and other one as empty
    // ["Hello","World"] => Hello%World
    // Hello%World => ["Hello", "World"]
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

    public List<String> decode(String str) {
        if (str.equals(Character.toString((char) 258))) return new ArrayList<>();

        String separator = Character.toString((char) 257);

        return Arrays.asList(str.split(separator, -1)); // to keep empty strings if they are exists in original list
    }
}
