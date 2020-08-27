
public class Leet33_Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{11,12,13,14,1,2,3,4}, 4));
    }
    static public int search(int[] nums, int target) {
        int pivot = nums[0];
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                pivot = i - 1;
                break;
            }
        }
        int res = BinarySearch(target, 0, pivot, nums);
        if (res != -1) {
            return res;
        }

        return BinarySearch(target, pivot + 1, nums.length - 1, nums);
    }

    static int BinarySearch(int target, int start, int end, int arr[]) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}