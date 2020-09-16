
public class Leet_ValidArrMountain {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3)
            return false;

        int left = 0, right = arr.length - 1;
        while (left < right && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right > left + 1 && arr[right - 1] > arr[right]) {
            right--;
        }
        if (left != 0 && left == right - 1 && arr[left] > arr[right])
            return true;
        return false;
    }
}