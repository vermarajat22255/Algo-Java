class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s.length() == 0) return result;
        
        helper(result, new ArrayList<String>(), s, 0);

        return result;
    }
    public void helper(List<List<String>> result, ArrayList<String> current, String s, int start){
        if(start == s.length()) {
            result.add(new ArrayList<String>(current));
            return;
        }
        for(int i=start; i<s.length(); i++){
            if(isPalindrome(s, start, i)){
                current.add(s.substring(start, i+1));
                helper(result, current, s, i+1);
                current.remove(current.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int left, int right){
        while(left < right)
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        return true;
    }
}
