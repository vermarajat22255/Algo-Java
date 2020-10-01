
public class Leet746_CountStairs {
    public int minCostClimbingStairs(int[] cost) {
        // 1 100 1 1 1 100 1 1 100 1
        // 1 100 2 3 3 103 4 5 104 6
        int dp[] = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 2], dp[i - 1]);
        }
        // System.out.println(Arrays.toString(dp));
        return Math.min(dp[dp.length - 2], dp[dp.length - 1]);
    }
}