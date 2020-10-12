class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length == 0 ) return result;
        
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> permutation = new ArrayList<>();
        
        Arrays.sort(nums);
        
        helper(result, nums, permutation, used);
        return result;
    }
    public void helper(List<List<Integer>> result, int nums[], ArrayList<Integer> permutation, boolean[] used){
        if(permutation.size() == nums.length) {
            result.add(new ArrayList(permutation));
            return;
        }
        
        for(int i=0; i<nums.length; ++i){
            if(used[i]) 
                continue;
            
            used[i] = true;
            permutation.add(nums[i]);
            
            helper(result, nums, permutation, used);
            used[i] = false;
            
            permutation.remove(permutation.size()-1);
            while(i+1 < nums.length && nums[i] == nums[i+1])
                ++i;
        }
    }
}
