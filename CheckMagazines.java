// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> h = new HashMap<>();
        boolean flag=false;
        for(int i=0;i<magazine.length;i++){
            if(h.containsKey(magazine[i])){
                int t = h.get(magazine[i]);
                h.put(magazine[i], ++t);
                }
            else
            h.put(magazine[i],1);
        }
        for(int i=0;i<note.length;i++){
            if(h.containsKey(note[i]) && h.get(note[i])>=1){
                int t = h.get(note[i]);
                h.put(note[i],--t);
            }
            else{
                System.out.println("No");
                flag=true;
                break;
            }
        }
//        System.out.println(h);
        if(!flag)
        System.out.println("Yes");
        
    }
