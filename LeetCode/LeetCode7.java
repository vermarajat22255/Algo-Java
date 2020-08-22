import java.lang.Math;
class Solution {
    public int reverse(int x) {
        boolean neg = x < 0? true:false;
        if(x == Integer.MIN_VALUE || x ==0 ) return 0;
        else x = Math.abs(x);
        
        String s = "";

        while(x != 0){
            s += x%10;
            x /= 10;
        }
    
        long l = Long.parseLong(s);
        if(l > Integer.MAX_VALUE) 
            return 0;
        
        int i = Integer.parseInt(s);
        
        if(neg == true)
           return -i;
        return i;
    }
}
class Solution {
    public int reverse(int x) {
        if(x == 0) return x;
        
        String rev = reverseNum(x);
        try{
            return Integer.parseInt(rev);
        }
        catch(Exception e){
            return 0;            
        }

    }
    String reverseNum(int x){
        if(x > 0 ) return new StringBuilder(x+"").reverse().toString();
        return "-"+(new StringBuilder((x+"").substring(1)).reverse().toString());
    }
}