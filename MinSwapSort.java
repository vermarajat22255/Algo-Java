import java.io.*;
import java.util.*;

public class MinSwapSort {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swap = 0;
        for (int i = 0; i < arr.length; i++) {
            int indx = getMinIndex(arr, i, arr.length);
            if (i != indx) {
                int temp = arr[i];
                arr[i] = arr[indx];
                arr[indx] = temp;
                swap++;
            }
        }
        return swap;
    }

    static int getMinIndex(int arr[], int start, int end) {
        int min = Integer.MAX_VALUE;
        int indx = start;
        for (int j = start; j < end; j++) {
            if (min > arr[j]) {
                min = arr[j];
                indx = j;
            }
        }
        return indx;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}