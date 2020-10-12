class Combination1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        helper(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    public void helper(List<List<Integer>> result, ArrayList<Integer> current, int k, int n, int start){
        if(current.size() == k){
            result.add(new ArrayList(current)); // [1,2] [1,3], [1,4]
            return;
        }
        for(int i = start; i<=n; i++){ // i = 1 stop -4 , ~i = 2,3,4 ,3-4 ,4-4
            current.add(i); // 2
            helper(result, current, k, n, i+1);
            current.remove(current.size()-1);
        }
    }
}
