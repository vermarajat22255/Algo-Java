class Solution {
    public int minCostToMoveChips(int[] position) {
        HashMap<String, Integer> freq = new HashMap<>();
        freq = getFreq(position);
        int cost=0;
        if(freq.get("even") <= freq.get("odd")){
            cost = freq.get("even");
        }else{
            cost = freq.get("odd");
        }
        return cost;
    }
    public HashMap<String,Integer> getFreq(int position[]){
        HashMap<String,Integer> res = new HashMap<String,Integer>();
        res.put("odd", 0);
        res.put("even", 0);
        for(int i=0; i<position.length; i++){
            if(position[i] %2 == 0){
                res.put("even", res.get("even")+1);
            }else{
                res.put("odd", res.get("odd")+1);
            }
        }
        return res;
    }
}
