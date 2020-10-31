class Leet45_JumpGame2{
    /*
       2 3 1 1 4
    2  0 1 1 . .
    3  X 0 1 1 1 
    1  X X 0 1 .
    1  X X X 0 1
    4  X X X X 0
    
       2 3  1     1  4 
       0 1  1,2   2  2
       
       1  2  3
       0  1  
    */
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1; i<nums.length; i++){
            int temp = dp[i-1]; // 0
            for(int j=i;j<i+nums[i-1]; j++){ //1
                
                if(j < nums.length){
                    dp[j] = Math.min(dp[j],temp+1);
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}
