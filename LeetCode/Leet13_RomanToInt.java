class Solution {
    public int romanToInt(String s) {
        int i=0, sum = 0;
        while(i+1 < s.length()){
            if( value(s.charAt(i)) < value(s.charAt(i+1))){
                sum = sum - value(s.charAt(i));
            }else{
                sum = sum + value(s.charAt(i));
            }
            i++;
        }
        return sum + value(s.charAt(i));
    }
    public int value(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
