class Solution {
    public int longestValidParentheses(String s) {
        
        int i=0,max=0,count=0, push=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        if(s.length() < 2) return max;
        
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                count = i-stack.peek();
                max = count>max?count:max;      
                }
            }
            i++;
        }
        
        System.out.println(stack);
        
        return max; 
    }
}


//Try 2 success

class Solution {
    public int longestValidParentheses(String s) {
        
        if(s.length() == 0 || s.length() == 1) return 0;
        Stack<Character> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek() == opposite(ch)){
                st.pop();
                al.remove(al.size()-1);
            }else{
                st.push(ch);
                al.add(i);
            }
        }
        
        if(al.size() == 0) return s.length();
        
        int max = Math.max(s.length()-al.get(al.size()-1), al.get(0)+1);
        
        for(int i= al.size()-1; i-1>= 0; i--){
            max = Math.max(max, al.get(i)-al.get(i-1));
        }
        
        return max-1;
    }
    static char opposite(char ch){
        if(ch == ')') return '(';
        return ' ';
    }
}