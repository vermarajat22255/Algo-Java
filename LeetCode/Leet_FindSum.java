import java.util.HashSet;

public class Leet_FindSum {

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                hs.add(arr[i]);
                if (hs.contains(arr[i] * 2) || (arr[i] % 2 == 0 && hs.contains(arr[i] / 2))) {
                    return true;
                }
            } else {
                zeroCount++;
                if (zeroCount == 2)
                    return true;
            }
        }
        return false;
    }
}