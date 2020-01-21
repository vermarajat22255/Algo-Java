// Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        HashMap<String,Integer> hm = new HashMap<>();
        int result[] = new int[queries.length];
        for(int i=0;i<strings.length;i++){
            if(hm.containsKey(strings[i])){
                hm.put(strings[i],hm.get(strings[i])+1);
            }else{
                hm.put(strings[i],1);
            }
        }
        for(int j=0;j<queries.length;j++){
            if(hm.containsKey(queries[j])){
                result[j] = hm.get(queries[j]);
            }else{
                result[j] = 0;
            }
        }
    return result;
    }
