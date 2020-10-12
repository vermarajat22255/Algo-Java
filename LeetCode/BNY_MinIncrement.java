import java.util.Arrays;

class BNY_MinIncrement {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2};
        //Output: 1
        int arr2[] = new int[]{3,2,1,2,1,7};
        //Output: 6
        minIncrementForUnique(arr);
        minIncrementForUnique(arr2);
    }
    private static int minIncrementForUnique(int[] A) {
            if(A.length == 0) return 0;
            Arrays.sort(A);
            int sum = 0;
            int max = A[0];
            for(int i=1; i<A.length; i++){
                // 1 1 2 2 3 7
                // 1 2 3 4 5 7   
                //   1 2 4 6 
                
                // 1 2 2
                // 1   
                if(A[i] <= max){
                    max = Math.max(max+1, A[i]);
                    sum += max - A[i];
                }else{
                    max = Math.max(max+1, A[i]);
                }
            }
            return sum;
        }
}