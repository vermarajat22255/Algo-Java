//    0  1  2  3  4  5  6  7  8  9  10  11
//1   0  1  2  3  4  5  6  7  8  9  10  11
//2   0  1  1  2  2  3  3  4  4  5   5   6
//5   0  1  1  2  2  1  2  2  3  3   2   3

// later mix all rows into one to make it a 1d array

class Leet322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp, amount+1); // some big number
        dp[0] = 0;
        
            for(int i=1; i<=amount; i++){
                for(int j=0; j<coins.length; j++){
                    if(i >= coins[j] ){
                        dp[i] = Math.min(dp[i-coins[j]]+1, dp[i]);
                    } 
                // System.out.print(dp[i]+" ");
            }
            // System.out.println(" ");
        }
        if(dp[amount] > amount)
            return -1;
        return dp[amount];
    }
}
