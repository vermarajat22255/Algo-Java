package LeetCode;

import java.util.Arrays;

public class HeapSort {
    public static void main(String args[]) {
        int arr[] = new int[]{-1,2,7,3,21,42,8};
        heapify(arr);

        System.out.println(Arrays.toString(arr));
        for(int i=arr.length-1; i>=0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            max_heapify(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }
    // 1 2 3 4 5  4 and 5 are leaf nodes
    /*             1
                 /   \
                2     3
               / \
              4   5
    */
    public static void heapify(int arr[]){

        for(int i = arr.length/2-1; i>= 0;  i--){
            max_heapify(arr, i, arr.length);
        }
    }
    public static void max_heapify(int arr[], int i, int n){
        int largest=i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left < n && arr[left] > arr[largest])
            largest = left;
        
        if(right < n && arr[right] > arr[largest])
            largest = right;
        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            max_heapify(arr, largest, n);
        }
    }
}