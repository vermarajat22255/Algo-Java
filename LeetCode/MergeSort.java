import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[]{1,14,3,7,2, 71, -1};
        mergeSort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int arr[], int start, int end) {
        int mid = start+(end -start)/2;
        if(start < end){
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }
    private static void merge(int arr1[], int start, int mid, int end){
        int l1 = mid-start+1;
        int r1 = end-mid;
        int L[] = new int[l1];
        int R[] = new int[r1];
        for(int i=0; i<l1; i++){
            L[i] = arr1[start+i];
        }
        for(int j=0; j<r1; j++){
            R[j] = arr1[mid+1+j];
        }
        int left = 0, right = 0, indx = start;
        while(left < l1 && right < r1){
            if(L[left] <= R[right]){
                arr1[indx] = L[left];
                left++;
            }else{
                arr1[indx] = R[right];
                right++;
            }
            indx++;
        }
        while (left < l1) { 
            arr1[indx] = L[left]; 
            indx++; 
            left++; 
        } 
  
        while (right < r1) { 
            arr1[indx] = R[right]; 
            indx++; 
            right++; 
        } 
    }
}
