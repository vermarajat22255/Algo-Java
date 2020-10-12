import java.util.*;

class Leet981_TimeBasedTreeMap {
    Map<String, TreeMap<Integer, String>> mappings;
    /** Initialize your data structure here. */
    public Leet981_TimeBasedTreeMap() {
        mappings = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mappings.containsKey(key))
            mappings.put(key, new TreeMap());
        mappings.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!mappings.containsKey(key)) return "";
        TreeMap<Integer, String> tree = mappings.get(key);
        Integer t = tree.floorKey(timestamp);
        return t!= null ? tree.get(t) :"";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */