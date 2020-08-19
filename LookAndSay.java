import java.util.Arrays;
import java.util.*;

public class LookAndSay {
    public static void main(String[] args) {
        String s = "1122231";
        HashMap<Character, Integer> hm = new HashMap<>();
        System.out.println("String gen is -> ");
        int count = 1;
        for (int i = 0; i < s.length(); i++) {

            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            System.out.print(count + "" + s.charAt(i));
            count = 1;
        }

    }
}