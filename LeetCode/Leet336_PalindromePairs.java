class Leet336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> result= new ArrayList<>();
        // if string i first matches i+1's last 
        // it can be palindrome -- test
        // if i's last matches i+1's first -- check palindrome
        
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                String word = words[i];
                String current = words[j];
                
                // Handle Null String
                if(word.equals("") || current.equals("")){
                    if(word.equals("") && checkPalindrome(current)){
                        ArrayList<Integer> al = new ArrayList<>();
                        al.addAll(Arrays.asList(new Integer[]{i, j}));
                        result.add(al);
                        ArrayList<Integer> al2 = new ArrayList<>();
                        al2.addAll(Arrays.asList(new Integer[]{j, i}));
                        result.add(al2);
                    }else if(current.equals("") && checkPalindrome(word)){
                        ArrayList<Integer> al = new ArrayList<>();
                        al.addAll(Arrays.asList(new Integer[]{i, j}));
                        result.add(al);
                        ArrayList<Integer> al2 = new ArrayList<>();
                        al2.addAll(Arrays.asList(new Integer[]{j, i}));
                        result.add(al2);
                    } 
                }
                else{
                    if(word.charAt(0) == current.charAt(current.length()-1)){
                        if(checkPalindrome(word+current)){
                            ArrayList<Integer> al = new ArrayList<>();
                            al.add(i);
                            al.add(j);
                            result.add(al);
                        }
                    }
                    if(word.charAt(word.length()-1) == current.charAt(0)){
                        if(checkPalindrome(current+word)){
                            ArrayList<Integer> al = new ArrayList<>();
                            al.add(j);
                            al.add(i);
                            result.add(al);
                        }
                    }
                }
            }
        }
        return result;
    }
    public boolean checkPalindrome(String s){
        for(int i=0; i<=s.length()/2; i++){
            if( !(s.charAt(i) == s.charAt(s.length()-1-i)))
                return false;
        }
        return true;
    }
}