import java.util.regex.*;

public class Leet8_Atoi {

    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) 
            return 0;
        if(str.length() == 1 && !Pattern.compile("\\d").matcher(str.charAt(0)+"").find()) 
            return 0;
        if((str.charAt(0) != '-' && str.charAt(0) != '+') && !Pattern.compile("\\d").matcher(str.charAt(0)+"").find())                return 0;
            
        // if starts with - and is a numbers
        
        if(str.charAt(0) == '-' && Pattern.compile("\\d").matcher(str.charAt(1)+"").find()){
            Matcher m = Pattern.compile("\\d+").matcher(str);
                if(m.find()) {
                    try{
                        return Long.parseLong("-"+m.group()) < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.parseInt("-"+m.group());       
                    }
                    catch(Exception e) {
                        return Integer.MIN_VALUE;
                    }
                }
        }
        
        // if its a positive number
        else if((str.charAt(0) == '+' && Pattern.compile("\\d").matcher(str.charAt(1)+"").find()) || Pattern.compile("\\d").matcher(str.charAt(0)+"").find()){
          Matcher m2 = Pattern.compile("\\d+").matcher(str);
            if(m2.find()){
                try{
                    return Long.parseLong(m2.group()) > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.parseInt(m2.group());
                }
                catch(Exception e) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}