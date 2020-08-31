import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Leet22_GeneratePar {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        backTrack(results, n, 0, 0, "");
        return results;
    }

    public void backTrack(ArrayList<String> result, int max, int open, int close, String current) {
        if (current.length() == 2 * max) {
            result.add(current);
            return;
        }
        if (open < max)
            backTrack(result, max, open + 1, close, current + "(");
        if (open > close)
            backTrack(result, max, open, close + 1, current + ")");
    }

    // public List<String> generateParenthesis(int n) {
    // if (n == 0)
    // return new ArrayList<String>();
    // // if( n == 1) return new ArrayList<String>().add("()");
    // ArrayList<String> al = new ArrayList<>();
    // HashSet<String> hs = new HashSet<>();
    // String given = "";
    // int i = 0;
    // while (i < n) {
    // given = given + "()";
    // i++;
    // }
    // int ln = given.length();
    // generateCombinations(given, 0, ln - 1, hs);

    // for (String s : hs) {
    // if (s.charAt(0) == '(') {
    // int j = 0;
    // Stack<Character> st = new Stack<>();
    // while (j < s.length()) {
    // if (!st.isEmpty() && s.charAt(j) == opposite(st.peek())) {
    // st.pop();
    // } else
    // st.push(s.charAt(j));
    // j++;
    // }
    // if (st.isEmpty())
    // al.add(s);
    // }
    // }
    // return al;
    // }

    // static char opposite(char ch) {
    // if (ch == '(')
    // return ')';
    // return ' ';
    // }

    // static void generateCombinations(String given, int l, int r, HashSet<String>
    // al) {
    // // generate only those string that begins with (
    // if (l == r)
    // al.add(given);

    // else {
    // for (int i = l; i < r; i++) {
    // char ch = given.charAt(i);
    // given = swap(given, l, i);
    // generateCombinations(given, l + 1, r, al);
    // given = swap(given, l, r);

    // }
    // }
    // }

    // static String swap(String s, int i, int j) {
    // char temp[] = s.toCharArray();
    // char ch = temp[i];
    // temp[i] = temp[j];
    // temp[j] = ch;
    // return String.valueOf(temp);
    // }
}