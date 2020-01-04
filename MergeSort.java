import java.util.*;

public class MergeSort {
    static void mergeSort(int a[],int p, int r) {
        if(p<r){
            int q = (p+r)/2;
            mergeSort(a, p, q);
            mergeSort(a, q+1, r);
            merge(a, p, q, r);
        }
    }
    static void merge(int a[], int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
      
        int left[] = new int[n1+1];
        int right[] = new int[n2+1];
      
        for (int i=0; i<n1; i++)
            left[i] = a[p + i];
      
        for (int i=0; i<n2; i++)
            right[i] = a[q + 1 + i];
      
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;
      
        int j = 0, i = 0;

        for (int k=p; k<=r; k++) {
            if(left[i] <= right[j]){
                a[k] = left[i];
                i++;
            }
            else {
                a[k] = right[j];
                j++;
            }
        }
    }
    public static void main(String args[]){
        int n;    
        Random r = new Random();
        Scanner sc = new Scanner(System.in); 
       
        System.out.println("Enter Number of elements");
        n = sc.nextInt();
        int a[] = new int[n];
    
        for(int i =0;i<n;i++){
            a[i] = r.nextInt(100000);
        }
    
        System.out.println("Before Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
        mergeSort(a,0,n-1);
        System.out.println("after Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
    }
}