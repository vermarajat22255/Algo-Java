class permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, nums, new ArrayList<Integer>()); // nothing used
        return result;
    }
    public void helper(List<List<Integer>> result, int nums[], ArrayList<Integer> used){
        if(used.size() == nums.length) {
            result.add(new ArrayList(used));
        }
        else{
            for(int i=0; i<nums.length;i++){
                if(used.contains(nums[i])) continue;
                used.add(nums[i]);
                helper(result, nums, used);
                used.remove(used.size()-1);
            }
        }
    }
}
