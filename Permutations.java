import java.util.Arrays;
import java.util.*;

public class Permutations {
    public static void main(String[] args) {

        String s = "ABC";
        ArrayList<String> al = new ArrayList<>();
        permute(s, al);
        System.out.println(al);
    }

    public static String permute(String s, ArrayList<String> al){
        String temp="";
        if(s == "") return "";
        // System.out.println("Created "+ s );
        for(Character ch: s.toCharArray()){
            temp = ch + "" +permute((s.substring(0, s.indexOf(ch)) + s.substring(s.indexOf(ch)+1, s.length())), al);
            
        }
        al.add(temp);
        // System.out.print(" returned "+ temp );
        return temp;
    }
}