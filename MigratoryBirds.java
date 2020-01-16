// Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        HashMap <Integer,Integer> hm = new HashMap();
        Iterator it = arr.iterator();
        int key=0,val=0;
        
        while(it.hasNext()){
            int temp = (int)it.next();
            if(hm.containsKey(temp)){
                hm.put(temp,hm.get(temp)+1);
            }
            else{
                hm.put(temp,1);
            }
        }
        
            System.out.println(hm);
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            
            if(val<e.getValue()){
             val = e.getValue();
             key = e.getKey();
            }
            else if(val == e.getValue() && key>e.getKey()){
             val = e.getValue();
             key = e.getKey();
            }
        }

    return key;
    }
