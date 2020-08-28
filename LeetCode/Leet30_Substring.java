import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s == null || s.length() == 0) return new ArrayList<Integer>();
        if(words.length == 0) return new ArrayList<Integer>();
        ArrayList<String> keys = new ArrayList<>(); 
        combinations(words,words[0], 0, words.length-1, keys);
        HashSet<Integer> res = new HashSet<>();
        
        // System.out.println("keys "+keys);
        
        //Check if each combination of key exist in string 
        //if exist save the index each time
        
        for(String key : keys){
            int from =0;
            
            while(s.indexOf(key, from) != -1){ 
                res.add(s.indexOf(key,from));
                from = s.indexOf(key,from) + 1;
            }
            from = 0;
        }
        
        
        // System.out.println(res);
        return new ArrayList(res);
    }
    
    
    ////////////// Compute the combinations of Keywords string //////////////////
    
    static void combinations(String[] words, String imp, int l, int r, ArrayList<String> keys){
        if(l == r) keys.add(imp);
        else{
            for(int i=l; i<=r; i++){
                imp = swap(l, i, words);
                combinations(words, imp, l+1, r,keys);
                imp = swap(l, i, words);
            }
        }
    }
    static String swap(int i, int j, String[] words){
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
        
        String res = "";
        for(String x: words) res = res+x; 
        return res;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////
}