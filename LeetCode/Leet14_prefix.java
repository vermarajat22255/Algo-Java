class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1) return "";
        String com = strs[0];
        int i = 1;
        while(i<strs.length){
            com = common(com, strs[i]);
            if(com.length()<1) break;
            i++;
        }
        return com;
    }
    public String common(String com, String other){
        int len = Math.min(com.length(), other.length());
        int i=0;
        while(i<len){
            if(com.charAt(i) != other.charAt(i)){
                break;
            }
            i++;
        }
        return com.substring(0, i);
    }
}

// Attempt 2 nice work
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        Arrays.sort(strs);

        String prefix = strs[0];
        int i =0, j=1;
        while(j < strs.length){
            i=0;
            while(i < prefix.length()){
                if(prefix.charAt(i) != strs[j].charAt(i)){
                    prefix = prefix.substring(0, i);
                    break;
                }
                i++;
            }
            j++;
        }
        return prefix;
    }
}
