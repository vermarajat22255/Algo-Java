import java.util.*;

public class HeapSort{
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

        heapSort(a, n-1);

        System.out.println("After Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }

    }
    static void maxHeapify(int a[], int i, int n){
        int left = 2*i;
        int right = 2*i +1;
        int largest;
        if(left<=n && a[left]>a[i])
            largest = left;
        else
            largest = i;
        if(right<=n && a[right]>a[largest])
            largest=right;
        if(largest !=i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;    
            maxHeapify(a, largest, n);
        }

    }
    static void buildMaxHeap(int a[], int n){
        for(int i=n/2;i>=0;i--){
            maxHeapify(a, i, n);
        }
    }
    static void heapSort(int a[], int n){
        int temp=0;
        buildMaxHeap(a, n);
        System.out.print("largest "+a[0]);
        System.out.print("smallest "+a[n]);
        
        for(int i=n;i>0;i--){
            temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            maxHeapify(a,0,i-1);
        }
    }
}