import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leet49_GroupAnagram {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, ArrayList<String>> mappings = new HashMap<>();
            ArrayList<List<String>> results = new ArrayList<>();
            for(int i=0; i<strs.length; i++){
                String key = sorted(strs[i]);
                if(mappings.containsKey(key)){
                    ArrayList<String> current = mappings.get(key);
                    current.add(strs[i]);
                    mappings.replace( key, current);
                    
                }else{
                    ArrayList<String> current = new ArrayList<>();
                    current.add(strs[i]);
                    mappings.put( key, current);            
                }
            }
            results.addAll(mappings.values());
            return results;
        }
        public String sorted(String s){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
}