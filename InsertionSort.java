import java.util.*;

public class InsertionSort {
    static void insertionSort(int a[]) {
        for(int i=1;i<a.length;i++) {
            int j=i-1;
            int key = a[i];
            while(j>=0 && a[j] > key) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1]=key;
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
        insertionSort(a);
        System.out.println("after Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
    }
}