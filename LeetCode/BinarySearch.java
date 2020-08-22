import java.util.Arrays;

public class BinarySearch {
    public static void main(String args[]) {
        int arr[] = { 100, 101, 102, 103, 104, 104 };
        int idx = Arrays.binarySearch(arr, 102);
        System.out.println("Called from Binary search method -> " + idx);
        System.out.println("called from the native method the ans is -> " + getBinarySearch(arr, 102));
    }

    static int getBinarySearch(int arr[], int key) {
        int left = 0, mid = 0, right = arr.length ;
        while (left < right-1) {
            mid = (right + left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }
}