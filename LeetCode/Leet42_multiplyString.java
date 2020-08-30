
public class Leet42_multiplyString {
    class Solution {
        public String multiply(String num1, String num2) {
            
            ArrayList<String> al = new ArrayList<>();
            if(num1.length() > num2.length()){
                String c = num1;
                num1=num2;
                num2=c;
            }
            // Multiply all the numbers
            //num2 chota length
            
            
            for(int i= num2.length()-1, count=0; i>= 0; i--, count++){
                char ch = num2.charAt(i);
                // if(ch == '0') return "0";
                String s = multiply(num1, ch);
                for(int k=0; k<count; k++){
                    s=s+"0";
                }
                al.add(s);
            }
            
            // Call add for temporary results
        
            System.out.println(al);
            String x = Add(al);
            return x.charAt(0) =='0'? "0" :x;
        }
        static String multiply(String num1, char ch){ //123 , 6
            int carry=0;
            int x = Integer.parseInt(ch+"");
            String result = "";
            
            for(int i=num1.length()-1; i>=0; i--){
                int y = Integer.parseInt(num1.charAt(i)+"");
                String temp = ((x*y)+carry)+"";
                result = temp.charAt(temp.length()-1)+result;
                carry = temp.length() > 1 ? Integer.parseInt(temp.substring(0, temp.length()-1)) : 0;
            }
            System.out.println("mul for 9*9 " + result);
            return carry !=0 ? carry+""+result : result;
        }
        static String Add(ArrayList<String> al){ 
            String res = al.get(0);
            for(int i=1; i<al.size();i++){
                res  = addTwo(res, al.get(i));
                System.out.println(res);
            }
            return res;
        }
        //  738
        // 615X
        static String addTwo(String a, String b){
            int carry=0;
            String result ="";
            int aptr = a.length()-1, bptr = b.length()-1;
            while(aptr >= 0 && bptr >=0 ){
                
                String temp=(Integer.parseInt(a.charAt(aptr)+"")+Integer.parseInt(b.charAt(bptr)+"")+carry)+"";
                result = temp.charAt(temp.length()-1)+result;
                carry = temp.length() > 1 ? Integer.parseInt(temp.substring(0, temp.length()-1)) : 0;
                aptr--;
                bptr--;
            }
                System.out.println("suffix --> "+result);
            
            //add carry to 6 and manage
            String prefix = "";
            if(aptr != -1) 
                prefix = (Integer.parseInt(a.substring(0, aptr+1))+carry)+"";
            else if(bptr!=-1)
                prefix = (Integer.parseInt(b.substring(0, bptr+1))+carry)+"";
            
            System.out.println("prefix --> "+prefix);
                
                
            return prefix+result;
        }
    }
}