public class Leet55_jumpGame {
    public boolean canJump(int[] nums) {
        int last_good = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= last_good) {
                last_good = i;
            }
        }
        return last_good == 0;
    }
}
