class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0) return result;
        
        ArrayList<Integer> current = new ArrayList<>();
        
        Arrays.sort(nums);
        
        helper(result, current, nums, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, ArrayList<Integer> current, int nums[], int start){
        
        result.add(new ArrayList<>(current));
        
        for(int i=start; i< nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            
            current.add(nums[i]);
            
            helper(result, current, nums, i+1);
            
            current.remove(current.size()-1);
            
        }
    }
}
