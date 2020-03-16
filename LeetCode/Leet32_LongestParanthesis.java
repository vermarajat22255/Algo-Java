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
