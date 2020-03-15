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
