class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        StringBuilder s = new StringBuilder(""+x);
        System.out.println(s.reverse());
        return s.toString().equals(s.reverse().toString());
    }
}
