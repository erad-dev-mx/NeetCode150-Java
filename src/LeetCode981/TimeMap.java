package LeetCode981;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Solution for LeetCode 981
 *
 * @see <a href="https://leetcode.com/problems/time-based-key-value-store/">LeetCode 981</a>
 * Time complexity: O(Log(N))
 * Space complexity: O(K * N)
 */

class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) return "";
        Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */