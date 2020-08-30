import java.util.Arrays;

public class Leet31_NextPermutation {
    public static void main(String args[]) {
        int x[] =new int[]{1,3,2};
        nextPermutation(x);  // gives 2,1,3
        System.out.println(Arrays.toString(x));
    }

    static void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;
        int ptr = nums.length - 1;
        while (ptr - 1 >= 0 && nums[ptr - 1] >= nums[ptr]) {
            ptr--;
        }
        if (ptr <= 0) {
            rev(ptr, nums);
            return;
        }
        // put min greater value from ptr to right at ptr-1
        int index = minThanTarget(nums[ptr - 1], ptr, nums);
        // System.out.println("index should be --> 2 "+ index);
        int temp = nums[ptr - 1];
        nums[ptr - 1] = nums[index];
        nums[index] = temp;
        // System.out.println("before rev "+ Arrays.toString(nums)+" aur index "+ptr);
        rev(ptr, nums);

    }

    static int minThanTarget(int target, int index, int[] nums) {
        int min = Integer.MAX_VALUE;
        int ind = -1;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] - target > 0) {
                min = Math.min(min, nums[i] - target);
                ind = i;
            }
        }
        return ind;
    }

    static void rev(int index, int[] nums) {
        int n = nums.length - index - 1;
        int j = 1;
        for (int i = 0; i <= n / 2; i++, j++) {
            int temp = nums[i + index];
            nums[i + index] = nums[nums.length - j];
            nums[nums.length - j] = temp;
        }
        // System.out.println("feka "+ Arrays.toString(nums));
    }
}