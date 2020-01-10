import java.util.*;

class QuickSort{
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

        quickSort(a, 0, n-1);

        System.out.println("After Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }

    }
    static int partition(int a[],int p, int r){
        int key= a[r];
        int i = p-1;
        for(int j=p;j<r-1;j++){
            
            if(a[j]<=key){
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp1 = a[i+1];
        a[i+1] = a[r];
        a[r] = temp1;

        return i+1;
    }
    static void quickSort(int a[],int p,int r){
        if(p<=r){
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
    }
}