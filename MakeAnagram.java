
??????????????????????????????????????????????????   IMPORTANT   ?????????????????????????????????????????????????????????????????????????????

    // Complete the makeAnagram function below.

//	we count all the occurance of letter in both string..
//	we start with one string and keep decreasing frequency in both maps if string 2 contain char from string 1,	
//	,but not decrease if value of char in string 2 is 0 or less  
    
static int makeAnagram(String a, String b) {
       HashMap<Character, Integer> hm1 = new HashMap();
       HashMap<Character, Integer> hm2 = new HashMap();
        int total=0;
        char ar[] =  a.toCharArray();
        for(int i=0;i<a.length();i++){
            char ch = a.toCharArray()[i];
            if(hm1.containsKey(ch)){
                int temp = hm1.get(ch);
                hm1.put(ch,++temp);
            }
            else{
                hm1.put(ch,1);
            }
        }
        for(int i=0;i<b.length();i++){
            char ch = b.toCharArray()[i];
            if(hm2.containsKey(ch)){
                int temp = hm2.get(ch);
                hm2.put(ch,++temp);
            }
            else{
                hm2.put(ch,1);
            }
        }
        
        for(char ch: ar){
            if(hm2.containsKey(ch) && hm2.get(ch)>0){
                int t1 =hm1.get(ch);
                int t2 = hm2.get(ch);

                hm1.put(ch,--t1);
                hm2.put(ch,--t2);

                // System.out.println("hm1 contains "+ch+"? "+t1);
                // System.out.println("hm2 contains "+ch+"? "+t2);
            }
        }
        
        System.out.println(hm1);
        System.out.println("---");
        System.out.println(hm2);

        for(int l: hm1.values()){
            total = total+l;
        }
        for(int m: hm2.values()){
            total = total+m;
        }

        return total;
    }
