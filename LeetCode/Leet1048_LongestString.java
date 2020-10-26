import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Leet1048_LongestString {
        public int longestStrChain(String[] words) {
            
            HashMap<String, Integer> map = new HashMap();
            
            for(int i=0; i<words.length; i++){
                map.put(words[i],1);          
            }
            
            Arrays.sort(words, (word1, word2) -> Integer.compare(word1.length(), word2.length()));
            for(int i=0; i< words.length; i++){
                String curr_word = words[i];
                for(int j=0; j<curr_word.length(); j++){
                    // remove one char at a time and see if it makes child
                    String left = "",right = "";
                    if(j-1 >= 0) left = curr_word.substring(0,j);
                    if(j+1 < curr_word.length()) right = curr_word.substring(j+1, curr_word.length());
                    String temp = left+right;
                    if(map.containsKey(temp)){
                        map.put(curr_word, Math.max(map.get(temp)+1, map.getOrDefault(curr_word,0)));
                    }
                }
            }
            return map.values().stream().max(Comparator.naturalOrder()).get();
        }
    /*
              bdca
          /   |     \    \
        dca  bca     bda  bdc
            / | \   / | \
          ca bc ba da bd ba
          
          a  b   c   d 
     a    1  0   0   0    
     b    0  1   0   0
     ba   2  2   0   0   
     bca  0  0   3   0    
     bda  0  0   0   3 
     bdca 0  0   4   4
     
    "" a b ab abc abd bcd abcd
     0 1 1  2  3   3   1   2,4,4
    */  
}
