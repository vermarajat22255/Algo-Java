package LeetCode;

public class Leet_countPrime {
    public int countPrimes(int n) {
        n = n - 1;
        if (n < 2)
            return 0;
        if (n == 3 || n == 2)
            return n - 1;
        int count = 2;
        for (int i = 5; i <= n; i = i + 2) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    static boolean isPrime(int x) {
        for (int j = 3; j <= Math.sqrt(x); j = j + 2) {
            if (x % j == 0)
                return false;
        }
        return true;
    }
}