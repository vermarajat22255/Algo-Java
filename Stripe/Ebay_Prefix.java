public class Ebay_Prefix {
    //aaacodedoc
    // cut max substring repeat till 
    // if max palindrome substring prefix is less than 2 word break

    public static void main(String args[]){
        System.out.println(" -->"+maxPalindromePrefix("codesignal"));
    }
    public static String maxPalindromePrefix(String s){
        String cut = "";
        while(true){
            for(int i=1; i<= s.length(); i++){
                if(new StringBuilder(s.substring(0, i)).reverse().toString().equals(s.substring(0, i)) && s.substring(0, i).length() > cut.length()){
                    cut = s.substring(0, i);
                    System.out.println(cut);
                }
            }
            if (cut.length() < 2 || s.length() == 0) break;
            else s = s.replaceAll(cut, "");
        }
        return s;
    }
}
