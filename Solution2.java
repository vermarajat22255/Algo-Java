import java.util.*;

class Solution2 {
    public static void main(String args[]){
        System.out.println(solve());
    }

    static int solve(){
        String A ="harder";
        String B = "rather";
        
        int chars[] = new int[26];  
          
        for (int i = 0; i < 26; i++){ 
            chars[i] = 0; 
        } 
        
        char t1[] = A.toCharArray();
        char t2[] = B.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        boolean flag = false;
        int max =0;
        
        if(A.length()<1 || B.length()<1) return max;
        
        if(t1.length == t2.length){
            int i=0;
            while(i<t1.length){
                if(t1[i] == t2[i]){
                    
                }
                else{
                    flag = true;
                    break;
                }
                i++;
            }
        
            if(!flag){
                return max;
            }
        }
        
//   aelpp
//   aepr
//   chars[a-a] -> 1 -> 0
//   chars[e-a] -> 1 -> 0
//   chars[l-a] -> 1
//   chars[p-a] -> 2 -> 1
//   chars[r-a] -> -1
  
        for (int i = 0; i < t1.length; i++)  
            chars[t1[i] - 'a']++;  
    
        for (int i = 0; i < t2.length; i++){  
            chars[t2[i] - 'a']--;   
        } 
        for (int i = 0; i < chars.length; i++)  
            {
                if (chars[i] != 0 )  
                ++max;
            }
        return max;
     }
}