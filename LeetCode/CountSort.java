package LeetCode;

import java.util.Arrays;

class CountSort {
    public static void main(String[] args) {
        int arr[] = new int[]{21,12,3,1, 3, 21, 2, 1};
        int k = Arrays.stream(arr).max().getAsInt();
        countSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
    public static void countSort(int arr[], int k){
        int temp[] = new int[k+1];
        for(int i=0;i<arr.length; i++){
            temp[arr[i]]+=1;
        }
        
        int indx=0;
        for(int j=0;j<temp.length; j++){
            if(temp[j] !=0){
                int num = j;
                while(temp[j] != 0){
                    arr[indx++] = num;
                    temp[j]--;
                }
            }
        }
    }
}