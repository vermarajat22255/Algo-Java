public static long getWays(int n, List<Long> c) {
    long dp[][] = new long[c.size()+1][n+1];
    Collections.sort(c);
    for(int i=0; i<dp.length; i++){
        for(int j=0; j<dp[i].length; j++){
            dp[i][0] = 1;
        }
        // System.out.println(Arrays.toString(dp[i]));
    }
    for(int i=1; i<dp.length; i++){
        for(int j=1; j<dp[i].length; j++){
            if(j >= c.get(i-1)){
                dp[i][j] = dp[i-1][j]+dp[i][j-c.get(i-1).intValue()];
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    return dp[dp.length-1][n];
 }
