import java.util.HashSet;

public class Leet3_LongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
       
            // O(n^2)
        
            if(s.length() == 0 || s.length() == 1) return s.length();
            
    //         int Maxlen=0, len=0;
    //         for(int i=0; i< s.length(); i++){
    //           Maxlen = Math.max(lenString(s.substring(i, s.length())), Maxlen);      
    //         }
                    
    //         return Maxlen;
    //     }
        
    //     int lenString(String s){
    //         int len =0;
    //         HashMap<Character, Integer> hm = new HashMap<>();
    //         for(int i=0; i<s.length(); i++){
                
    //             char ch = s.charAt(i);
                
    //             if(hm.containsKey(ch)){
    //                 return len;
    //             }
    //             len++;
    //             hm.put(ch, i);
    //         }
    //         return len;
    //     }
            
            //O(n)
            // pewwkew
            //start with left and right being equal slide right until end
            // if char repeats increase the left pointer by one else move right to the end
            
            int i=0, j=0, maxLen =0;
            int n = s.length();
            HashSet<Character> hm = new HashSet<>();
            while(i < n  && j <  n){
                char ch = s.charAt(j);
                if(hm.contains(ch)){
                    maxLen = Math.max(maxLen, j-i);
                    hm.remove(s.charAt(i));
                    i++;
                }else{
                    hm.add(ch);
                    j++;
                }
            }
            return maxLen > j-i ? maxLen : j-i;
    }}

}