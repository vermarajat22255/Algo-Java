import java.util.Arrays;

public class QuickSort{
    public static void main(String[] args) {
        int arr[] = new int[]{22,-1, 3,7,26, 5};
        quickSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    
    private static void quickSort(int[] arr, int start, int end) {
        if(start < end){
            int q = partition(arr, start, end);
            quickSort(arr, start, q-1);
            quickSort(arr, q+1, end);
        }
    }
    private static int partition(int arr[], int start, int end ){
        int key = arr[end-1];
        int i=start-1;
        for(int j = start; j<end; j++){
            if(arr[j] < key){
                //swap i and j. inituition is put i which is smaller backwards as we progress
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp; 
            }
        }
        //swap key and i+1
        arr[end-1] = arr[i+1];
        arr[i+1] = key;
        return i+1;
    }
}