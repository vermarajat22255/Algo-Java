
public class Leet33_search {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                int x = binarySearch(0, i, nums, target);
                int y = binarySearch(i, nums.length - 1, nums, target);
                // System.out.println(x+" and "+y);
                return Math.max(x, y);
            }
        }
        return binarySearch(0, nums.length - 1, nums, target);
    }

    static int binarySearch(int to, int from, int arr[], int target) {
        while (to <= from) {
            int mid = to + (from - to) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                to = mid + 1;
            else
                from = mid - 1;
        }
        return -1;
    }
}