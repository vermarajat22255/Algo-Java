class Leet139_WordBreak {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
//         boolean dp[][] = new boolean[n][n];
//         for(int i=0;i<n;i++)
//             Arrays.fill(dp[i],false);
        
//         for(int i=0; i<n;i++){
//             for(int j=0; j<n-i;j++){
//                 dp[j][i+j] = checkDict(s.substring(j,i+j+1),wordDict, dp);
//             }
//         }
//         return dp[0][dp[0].length-1];
//     }
//     public boolean checkDict(String s, List<String> wordDict, boolean[][] dp){
//         if(wordDict.contains(s)) return true;
//         else{
//           for(int i=0; i<s.length()-1;i++){
//               boolean subans = checkDict(s.substring(0, i+1),wordDict) && checkDict(s.substring(i+1, s.length()),wordDict);
//               if(subans) return true;
//               else continue;
//           }
//         }
//         return false;
//     }
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(String str : wordDict){
                if(str.length() <= i){ //because if str length > s then s can no way exist & cover str  
                    if(dp[i-str.length()]){
                        if(s.substring(i-str.length(),i).equals(str)){
                            dp[i] =true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[dp.length-1];
    }
}

/*
        intuition is 
        can i make small string that can be segmented into word
        which is one or more in dictionary 
        is s(0,0) in can be segmented into dictionary
        is s(0,1) or s(0,0)+s(1,1) in dictionary
        
        l e e t c o d e
        0 1 2 3 4 5 6 7       
        [leet, code]
        
        
        0 1 2 3 4 5 6 7
    0   F F F T F F F T       
    1   X F F F F F F F         
    2   X X F F F F F F          
    3   X X X F F F F F            
    4   X X X X F F F T                
    5   X X X X X F F F                
    6   X X X X X X F F               
    7   X X X X X X X F                
    */