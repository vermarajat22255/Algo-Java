
public class Leet3_LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;

        HashMap<Character, Integer> hm = new HashMap<>();
        int maxLen = 0, len = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            System.out.println(ch);

            if (hm.containsKey(ch)) {
                hm.clear();
                if (len > maxLen)
                    maxLen = len;

                len = 0;
            }
            hm.put(ch, 1);
            len++;
        }
        maxLen = maxLen > len ? maxLen : len;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            System.out.println(ch);

            if (hm.containsKey(ch)) {
                hm.clear();
                if (len > maxLen)
                    maxLen = len;
                len = 0;
            }
            hm.put(ch, 1);
            len++;
        }

        return maxLen > len ? maxLen : len;
    }

}