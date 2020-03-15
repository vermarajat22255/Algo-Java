class Solution {
    public String longestPalindrome(String s) {
        //get all substring
        return getAll(s);
    }
    public String getAll(String s){
        HashMap<StringBuilder,Integer> hm = new HashMap<>();
        int max =0;
        String res ="";
        for(int i=0;i<s.length();i++){
            
            for(int j=s.length();j>=i;j--){
                
                StringBuilder sub = new StringBuilder(s.substring(i,j));
             
                if(sub.length()<1 || sub.charAt(0) != sub.charAt(sub.length()-1)) continue;
                
                if(!hm.containsKey(sub)){
                    if(sub.toString().equals(new StringBuilder(sub).reverse().toString())){
                        hm.put(sub, sub.length());
                        if(max<sub.length()){
                            max=sub.length();
                            res = sub.toString();
                        }
                    }
                    else{
                        hm.put(sub,-1);
                    }
                }
            }
        }
        return res;
    }
}
/////////////////////////////////Brute Force didnt worked////////////////////////////////

class Solution {
    public String longestPalindrome(String s) {
        int len1=0, len2=0, len=0;
        int start =0, end=0;
        if(s ==null || s.length() < 1) return "";
        for(int i=0;i<s.length();i++){
            
            len1 = expand(s, i, i);
            len2 = expand(s, i, i+1);
            len = Math.max(len1,len2);
            if(len > end-start){
                start = i - (len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }
    public int expand(String s, int left, int right){
        while(left>=0 && right< s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
