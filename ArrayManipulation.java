import java.util.*;

public class ArrayManipulation {
    public static void main(String[] arg) {
    int n = 5;
    int[][] queries = new int[3][3];
    queries[0][0]=1;
    queries[1][0]=2;
    queries[2][0]=3;
    queries[0][1]=2;
    queries[1][1]=5;
    queries[2][1]=4;
    queries[0][2]=100;
    queries[1][2]=100;
    queries[2][2]=100;
    long result = arrayManipulation(n, queries);
    System.out.println(result);
}

static long arrayManipulation(int n, int[][] queries) {
        long output[] = new long[n+2];
        long max= Long.MIN_VALUE;
        for(int i=0;i<queries.length;i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            int k = queries[i][2];
            output[a] += k;
            output[b+1] -= k;
        }
        
        long sum=0;
        for(int i=0;i<output.length;i++){
            sum += output[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
