
public class Leet35_search {
    public int searchInsert(int[] nums, int target) {
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
        return to;
    }

}