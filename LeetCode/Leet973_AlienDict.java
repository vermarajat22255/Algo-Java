class Leet973_AlienDict {
    public boolean isAlienSorted(String[] words, String order) {
        int mapping[] = new int[26];
        int j=0;
        for(char ch: order.toCharArray()){
            mapping[ch-'a'] = j++;
        }
        for(int i=1; i<words.length; i++){
            if(bigger(words[i-1],words[i], mapping))
                return false;
        }
        return true;
    }
    public boolean bigger(String word1, String word2, int[] mapping){
        int n = word1.length(), m = word2.length();
        for(int i=0; i<Math.min(n,m); i++){
            if(word1.charAt(i) != word2.charAt(i))
                return mapping[word1.charAt(i)-'a'] > mapping[word2.charAt(i)-'a'];
        }
        return n>m;
    }
}
