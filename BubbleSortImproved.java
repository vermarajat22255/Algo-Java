    // Complete the countSwaps function below.
    
    // if there is no swap in first iteration that means array is already sorted, so will break the loop
    
    static void countSwaps(int[] a) {
        int total=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    total++;
                }
            }
            if(total == 0) break;
        }
        
        System.out.println("Array is sorted in "+total+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[a.length-1]);        
    }
