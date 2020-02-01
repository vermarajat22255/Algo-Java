    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    Stack <Character> stack = new Stack<>();
    stack.push(s.charAt(0));
    if(s.length()<2) return "NO";
    for(int i=1; i<s.length();i++){
        
        if(stack.isEmpty() || s.charAt(i) != opposite(stack.peek()))
        {
            stack.push(s.charAt(i));
        }else{
                stack.pop();
        }
    }
    if(stack.isEmpty()) return "YES";
    return "NO";
    }
    static char opposite(char ch){
        switch (ch){
            case '{' : return '}';

            case '(' : return ')';

            case '[' : return ']';

        }
        return '\0';
    }
