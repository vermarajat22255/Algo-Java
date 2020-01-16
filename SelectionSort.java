import java.util.Scanner;
import java.util.Random;

class SelectionSort{

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
 
 
    a = selectionSort(a);

    System.out.println("after Sorting");

    for(int i =0;i<n;i++){
        System.out.println(a[i]);
    }
    sc.close();
    }

    static int[] selectionSort(int a[]){
        int min=0;
        for(int i=0;i<a.length;i++){
            min=i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[min]){
                    min = j;
                }
            }
            int temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }
}
