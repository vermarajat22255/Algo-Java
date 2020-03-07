 // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        int index =1;
        for(int x: cost){
            hm.put(x, index);
            index++;
        }
        //System.out.print(hm);
        for(int i=0;i<hm.size();i++){
            if(hm.containsKey(money-cost[i])) {
                System.out.print(i+1);
                System.out.println(" "+hm.get(money-cost[i]));
                break;
            }
        }
    }
