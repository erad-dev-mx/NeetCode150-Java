package LeetCode981.Review;

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

    public TimeMapReviewV2() {

    }

    public void set(String key, String value, int timestamp) {

    }

    public String get(String key, int timestamp) {

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
