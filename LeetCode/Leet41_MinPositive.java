import java.util.HashMap;

public class Leet41_MinPositive {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && !hm.containsKey(nums[i])) {
                hm.put(nums[i], 1);
            }
        }
        int key = 1;
        while (true) {
            if (!hm.containsKey(key)) {
                return key;
            }
            key++;
        }
    }
}