import java.util.Stack;

public class Leet20_ValidPar {

    public boolean isValid(String s) {
        if (s.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && isOpposite(stack.peek()) == ch)
                stack.pop();
            else
                stack.push(ch);
        }
        return stack.isEmpty();
    }

    static char isOpposite(char x) {
        switch (x) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
            default:
                return ' ';
        }
    }

}