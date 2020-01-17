import java.util.*;

public class RadixSort {
    
    public static void main(String args[]){
        int n;
        Random r = new Random();
        Scanner sc = new Scanner(System.in); 
       
        System.out.println("Enter Number of elements");
        n = sc.nextInt();
        int a[] = new int[n];
    
        for(int i = 0;i<n;i++){
            a[i] = r.nextInt(1000);
        }
    
        System.out.println("Before Sorting");
    
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
        System.out.println("Sorting started...");
        a = radixSort(a,3);
        System.out.println("after Sorting");
        for(int i =0;i<n;i++){
            System.out.println(a[i]);
        }
        sc.close();
    }
    static int[] radixSort(int a[],int d) {
        
        int digits[] = new int[a.length];
        int count =0;
        for(int i =0;i<a.length;i++){
            digits[i] = a[i];
        }
         
        int r=10; 
        while(count<d){
            
            for(int i=0;i<=digits.length-1;i++){
                digits[i] = digits[i]%10;
            }

            a = countSort(a,digits);
            //a = insertionSort(a,digits);
            System.out.println("______");
            for(int i=0;i<=digits.length-1;i++){
                
                digits[i] = a[i]/r;
                 //System.out.println("hona chahiye /10 "+digits[i]);
            }
        
            count++;
            r=r*10;
        }
        return a;
    }

    static int[] countSort(int a[],int digits[]) {

        int cd[] = new int[11];
        
        int b[] = new int[a.length];
        
        for(int i=0;i<digits.length;i++) {
            ++cd[digits[i]];
        }
        for(int i=1;i<10;i++){
            cd[i] += cd[i-1];
        }

        for(int i=0;i<digits.length;i++) {
            b[cd[digits[i]]-1] = a[i];
            cd[digits[i]] = cd[digits[i]] -1; 
        }

        for(int i=0;i<b.length;i++){
            System.out.println("b hua "+b[i]+" from "+a[i]);
        }
        return b;
    }
    static int[] insertionSort(int a[], int digits[]){
        int j,temp,tempo;
        for(int i=1;i<digits.length;i++){
            j=i-1;  
            temp = digits[i];
            tempo = a[i];
            while(j>=0 && temp<digits[j]){
                    digits[j+1] = digits[j];
                    a[j+1] = a[j];
                    j--;
                }
            a[j+1] = tempo;
            digits[j+1]=temp;
        }

        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
        return a;
    }
}
