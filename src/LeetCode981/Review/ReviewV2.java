package LeetCode981.Review;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// key -> value + timeStamp
// set ("p", "v", 1)
// set ("p", "j", 2)
// set ("p", "k", 3)
// get ("p", 2) => "j"
// get ("p", 7) => "k" // We found the floor value since 7 is not present
// get ("j", 5) => ""
// set ("j", "c", 6)

// We can use HashMap in key we save key and for value and timeStamp we use a TreeMap
// set ("p", "v", 1)
// HashMap[("p", TreeMapInstance1)], TreeMapInstance1[(1, "v")]
// set ("p", "h", 3)
// HashMap[("p", TreeMapInstance1)], TreeMapInstance1[(1, "v"), (3, "h")]
// set ("p", "i", 5)
// HashMap[("p", TreeMapInstance1)], TreeMapInstance1[(1, "v"), (3, "h"), (5, "i")]
// set ("j", "c", 7)
// HashMap[("p", TreeMapInstance1), ("j", TreeMapInstance2)]
// TreeMapInstance1[(1, "v"), (3, "h"), (5, "i")], TreeMapInstance2[(7, "c")]
//  Time complexity: O(Log(N))
// Space complexity: O(K * N)
class TimeMapReviewV2 {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMapReviewV2() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return "";
        }
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
