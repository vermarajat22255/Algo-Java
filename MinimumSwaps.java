2 3 4 1 5
1 3 4 2 5
1 2 4 3 5
1 2 3 4 5


MINIMUM Swap required to sort a consucutive number is basically putting number on their own index..ex - 3 will come on 3 position start from 0 to last and replace untill no[i]<no[i+1]


-->WHICH IS NOT BASICALLY ALWAYS MINIMUM SWAP

 // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] a) {
        int pos,temp;
        for(int i=1;i<a.length;i++){
            if(a[i-1]>a[i]){
                pos = a[i-1]-1;
                temp = a[pos];
                a[pos] = a[i-1];
                a[i-1] = temp;
                count++;
                i=0;
            }
        }
        for (int i=0;i<a.length;i++)
        System.out.print(a[i]);
        return count;
    }

