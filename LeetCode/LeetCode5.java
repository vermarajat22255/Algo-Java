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

// Try 2
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1) return s;
        if(s.equalsIgnoreCase(new StringBuilder(s).reverse().toString())) return s;
        int j=1;
        String res = "";
        
        //case 1: one odd character and others repeats
        
        for(int i=1; i+j<s.length();i++){
            
            while( (i+j+1 <= s.length()) && i-j >= 0 && s.charAt(i+j) == s.charAt(i-j)){
                res = s.substring(i-j, i+j+1).length() > res.length() ? s.substring(i-j, i+j+1) : res;
                System.out.println(res);
                j++;
            }
            j=1;
        }
        
        // case 2: when same character repeats
        int left=0,right=1;
        String temp ="";
        while(right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                temp = s.substring(left, right+1).length() > temp.length() ? s.substring(left, right+1) : temp;
            }else{
                left++;
            }
            right++;
        }
        return temp.length() > res.length() ? temp : (temp.length() == 0 && res.length() ==0 ? s.charAt(0)+"" : res);

        // Missed a case 3 when string is like xtarratz  => tarrat
    }
}