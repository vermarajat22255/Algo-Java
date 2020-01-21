static String isValid(String s) {
        LinkedHashMap<Character,Integer> hm = new LinkedHashMap<>();
        int ar[] = new int[s.length()];
        int i=0, count=0;
        while(i<s.length()){
            char ch = s.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch,hm.get(ch)+1);
            }
            else{
                hm.put(ch,1);
            }
            i++;
        }
        System.out.println(hm);
        ArrayList<Integer> al = new ArrayList(hm.values());
        //System.out.print(al);
        //sabki +- 1 hogi jiske bhi +-1 ho ese bus 1 hi ho skte
        int freq = al.get(0);
        for(int j=1;j<al.size();j++){
            int temp = al.get(j);
            if( temp!=freq) count++;
            if(count>1) return "NO";
        }
        return "YES";
    }

//////////////////////////////////////////////////////////////////correct////////////////////////////////////////////////////////////////////////////
    static String isValid(String s) {
        int ltr[] = new int[26];
        for(int i=0;i<s.length();i++){
            ltr[s.charAt(i)-'a']++;
        }
        Arrays.sort(ltr);
        int j=0;
        while(ltr[j]==0){
            j++;
        }
        int min = ltr[j];
        int max = ltr[25];
        String res="NO";
        if(max == min ) return "YES";
        if(max-min==1 && max>ltr[24] || min==1 && max ==ltr[j+1]) return "YES";
        return res;
    }
