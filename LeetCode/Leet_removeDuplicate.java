
public class Leet_removeDuplicate {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;
        int j = 1;
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[j] = nums[i];
                j++;
            }
        }
        // System.out.println("J is -> "+j+" nums[j] ->"+nums[j]);
        return j;
    }
}