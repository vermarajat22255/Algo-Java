class RevString_Rec {
    public void reverseString(char[] s) {
        helper(s, 0);
    }
    public void helper(char[] s, int idx){
        if(idx == s.length/2) return;
        helper(s, idx+1);
        char ch = s[idx];
        s[idx] = s[s.length-1-idx];
        s[s.length-1-idx] = ch;
    }
}