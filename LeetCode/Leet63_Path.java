class Leet63_Path {
     public int uniquePaths(int m, int n) {
         int dp[][] = new int[m][n];
         for(int i=0; i<m; i++) dp[i][0]=1;
         for(int i=0; i<n; i++) dp[0][i]=1;
         for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
         return dp[m-1][n-1];
    }   
}

/*
     X X X
     X X X
     X X O
	recursive approach time out
     public int uniquePaths(int m, int n) {
        int path = 0;
        
        path = helper(0,0,Math.max(m, n),Math.min(m, n) , 0);
        return path;
    }
    public int helper(int i, int j, int m, int n, int path){
        if(i == m-1 && j == n-1) {
            path++;
            // System.out.println(path);
            return path;
        }
        else{
            if(i < m) path = helper(i+1, j, m, n, path);
            if(j < n) path = helper(i, j+1, m, n, path);
        }
        return path;
    }
*/
