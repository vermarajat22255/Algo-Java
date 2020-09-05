import java.util.LinkedHashMap;
import java.util.Map;

public class Leet_FirstNonRepeating {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> e : hm.entrySet()) {
            if (e.getValue() == 1)
                return s.indexOf(e.getKey() + "");
        }
        return -1;
    }
}
//Without using the HashMap
