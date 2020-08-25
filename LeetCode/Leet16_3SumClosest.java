import java.util.Arrays;

public class Leet16_3SumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE, diff = Integer.MAX_VALUE, finalSum = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = nums.length - 1;
            System.out.println("*************" + i + " left -> " + left + " right ->" + right + " *****************");
            while (left < right) {

                if (left == i)
                    left++;
                if (right == i)
                    right--;
                if (right == left)
                    break;

                sum = (nums[i] + nums[left] + nums[right]);

                if (Math.abs(target - sum) < diff) {
                    System.out.println(
                            "nums[i] -> " + nums[i] + " nums[left] ->" + nums[left] + " nums[right] " + nums[right]);
                    diff = Math.abs(target - sum);
                    finalSum = sum;
                    System.out.println("diff->" + diff + " sum " + sum + " final sum " + finalSum);
                }
                if (sum == target)
                    return sum;
                else if (sum < target)
                    left++;
                else
                    right--;

            }
        }
        return finalSum;
    }

}