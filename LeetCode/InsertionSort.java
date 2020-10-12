import java.util.Arrays;
public class InsertionSort{

     public static void main(String []args){
        int arr[] = new int[]{12,31,42,11,9,-1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
     }
     public static void insertionSort(int arr[]){
        for(int right=1;right<arr.length; right++){
            int left=right-1;
            int key = arr[right];
            // 4 2 1 3 
            // 2 1 4
            while(left >= 0 && arr[left] > key ){
                arr[left+1] = arr[left];
                left--;
            }
            arr[left+1] = key;
        }
     }
}