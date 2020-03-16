class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && reverse(stack.peek())==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
            i++;
        }
        System.out.println(stack);
        if(stack.isEmpty()) return true;
        return false;
    }
    public char reverse(char ch){
        switch (ch){
        case '{': return '}';
        case '[': return ']';
        case '(': return ')';
        default: return ch;
        }
    }
}
