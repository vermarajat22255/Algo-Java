package LeetCode;

import java.util.ArrayList;

public class Leet_SlidingWindow {

    // [-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7] 7
    // 5
    //
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        ArrayList<Integer> al = new ArrayList<>();
        int idx = getMaxIndex(nums, 0, k);

        for (int i = 0; i <= nums.length - k; i++) {

            if (idx >= i && idx < i + k) {
                if (nums[idx] < nums[i + k - 1]) {
                    idx = i + k - 1;
                }
                al.add(nums[idx]);
            } else {
                idx = getMaxIndex(nums, i, k); // from window get max
                al.add(nums[idx]);
            }
        }
        return al.stream().mapToInt(x -> x).toArray();
    }

    public int getMaxIndex(int nums[], int start, int end) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i < start + end; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }
}