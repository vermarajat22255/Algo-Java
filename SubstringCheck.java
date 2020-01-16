// Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        HashSet h = new HashSet();
        
        for(int i=0;i<s1.length();i++){
            h.add(s1.charAt(i));
        }
        
        int i=0;
        while(i<s2.length()){
            if(h.contains(s2.charAt(i))){
                return "YES";
            }
            i++;
        }
        return "NO";
    }
