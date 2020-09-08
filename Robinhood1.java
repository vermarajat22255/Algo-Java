import java.util.HashMap;

public class Robinhood1 {
    private static HashMap<Long, Long> hm = new HashMap<>();

    public static void main(String[] args) {
        int arr[] = { 1, 20, 2, 11 };
        // returns the number of pairs such that
        // i<= j and arr[i]+rev(arr[j) == rev(arr[i]) + arr[j]

        // 2147483647 --> 7463847412l
        populateList(arr);

        System.out.println(oppositeSums(arr));

    }

    static int oppositeSums(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if ((arr[i] + hm.get(new Long(arr[j]))) == (hm.get(new Long(arr[i])) + arr[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    static long reverse(long x) {
        return Long.parseLong(new StringBuilder(x + "").reverse().toString());
    }

    static void populateList(int arr[]) {

        for (int i = 0; i < arr.length; i++) {

            if (!hm.containsKey(arr[i])) {
                long temp = reverse(arr[i]);
                hm.put(new Long(arr[i]), temp);
                hm.put(temp, new Long(arr[i]));
            }
        }
    }
}