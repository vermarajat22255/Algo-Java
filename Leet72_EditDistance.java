class Leet72_EditDistance {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int j=0;j<dp[0].length;j++){
              dp[0][j] = j;  
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=1; i<dp.length; i++){
            for(int j=1;j<dp[i].length; j++){
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);
                
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        // for(int i=0;i<dp.length;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[word1.length()][word2.length()];
    }
}
