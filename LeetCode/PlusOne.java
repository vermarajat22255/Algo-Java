import java.util.Arrays;

public class PlusOne{
    public static void main(String args[]) {
        int[] digits = {2,4,9,3,9};
        digits = plusOne(digits);
        for(int x: digits)
        System.out.print(x+" ");
    }
    static int[] plusOne(int[] digits) {
        if(digits[digits.length-1]+1 <= 9){
            digits[digits.length-1] = digits[digits.length-1]+1;
            return digits;
        }
        String temp = (digits[digits.length-1]+1)+"";
        int carry = 0;
        String res = "";
        
        for(int i=digits.length-2; i>=0; i--){
            if(temp.length() > 1){
                res =  temp.charAt(temp.length()-1)+""+res;         // 0
                carry = Integer.parseInt(temp.substring(0, temp.length()-1)); // 1
                temp = (digits[i]+carry)+"";    //4
            }else{
                    res = digits[i]+""+temp+res; //940
                    temp = "";
            }
        }
        if(temp.length() !=0 ){
            res = temp+res+"";
            carry =0;
        }
        return new int[]{1,2};
    }
}