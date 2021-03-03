class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right=0;
        if(s.length() <= 1) return s.length();
        
        HashSet<Character> seen = new HashSet();
        int max = 0;
        while(right != s.length()){
            Character curr = s.charAt(right);
            if(!seen.contains(curr)){
                seen.add(curr);
                right++;
            }else{
                // pwkwq
                seen.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, seen.size());
        }
        return max;
    }
}
