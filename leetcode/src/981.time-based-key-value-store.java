/*
 * @lc app=leetcode id=981 lang=java
 *
 * [981] Time Based Key-Value Store
 *
 * https://leetcode.com/problems/time-based-key-value-store/description/
 *
 * algorithms
 * Medium (51.89%)
 * Likes:    505
 * Dislikes: 67
 * Total Accepted:    45.3K
 * Total Submissions: 87.4K
 * Testcase Example:  '["TimeMap","set","get","get","set","get","get"]\n' +
  '[[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]'
 *
 * Create a timebased key-value store class TimeMap, that supports two
 * operations.
 * 
 * 1. set(string key, string value, int timestamp)
 * 
 * 
 * Stores the key and value, along with the given timestamp.
 * 
 * 
 * 2. get(string key, int timestamp)
 * 
 * 
 * Returns a value such that set(key, value, timestamp_prev) was called
 * previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the one with the largest
 * timestamp_prev.
 * If there are no values, it returns the empty string ("").
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs =
 * [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:   
 * TimeMap kv;   
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with
 * timestamp = 1   
 * kv.get("foo", 1);  // output "bar"   
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to
 * foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie
 * "bar"   
 * kv.set("foo", "bar2", 4);   
 * kv.get("foo", 4); // output "bar2"   
 * kv.get("foo", 5); //output "bar2"   
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: inputs = ["TimeMap","set","set","get","get","get","get","get"],
 * inputs =
 * [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * Output: [null,null,null,"","high","high","low","low"]
 * 
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All key/value strings are lowercase.
 * All key/value strings have length in the range [1, 100]
 * The timestamps for all TimeMap.set operations are strictly increasing.
 * 1 <= timestamp <= 10^7
 * TimeMap.set and TimeMap.get functions will be called a total of 120000 times
 * (combined) per test case.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class TimeMap {

    private Map<String, List<Pair>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(value, timestamp));
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, null);
        if(list == null) {
            return "";
        }
        int index = Collections.binarySearch(list, new Pair("", timestamp));
        if(index < 0) {
            index *= -1;
            index -= 2;
        }
        if(index < 0) {
            return "";
        }
        return list.get(index).value;
    }

    private static class Pair implements Comparable<Pair> {
        public String value;
        public int timestamp;
        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.timestamp - pair.timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;
            return this.timestamp == pair.timestamp;
        }

        @Override
        public int hashCode() {
            return this.timestamp;
        }

    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
// @lc code=end
