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
