import java.util.HashMap;

public class CanMakePalindrome {
    
    public static void main(String args[]) {
        String s = "GATTAACACGDC";
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(Character ch : s.toCharArray()){
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch, 1);
            }
        }
        for (Character ch : hm.keySet()){
            if(hm.get(ch) % 2 != 0){
                count++;
                if( count > 1) {
                    System.out.println("Not a palindrome");
                    return ;
                }
            }
        }
        System.out.println("Palindrome");
    }
}