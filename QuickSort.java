import java.util.*;

public class QuickSort {
    
    public static void main(String args[]){
        int n;    
        Random r = new Random();
        Scanner sc = new Scanner(System.in); 
       
        System.out.println("Enter Number of elements");
        n = sc.nextInt();
        int a[] = new int[n];
    
        for(int i = 0;i<n;i++){
            a[i] = r.nextInt(100000);
        }
    
        System.out.println("Before Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
        quickSort(a, 0, n-1);
        System.out.println("after Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
    }

    static void quickSort(int a[],int p, int r) {
        if(p<r) {
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }

    static int partition(int a[],int p, int r) {
        int x = a[r];
        int i = p-1;
        for(int j = p; j<=r-1; j++) {
            if(a[j]<=x) {
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        int temp = a[r];
        a[r] = a[i+1];
        a[i+1]=temp;
        return i+1;
    }
}