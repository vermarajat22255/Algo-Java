class Leet_ValidPalin {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase().replaceAll("[^a-z0-9]+", "");
        System.out.println(s);
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}