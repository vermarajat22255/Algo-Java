import java.util.ArrayList;
import java.util.List;

class LeetCode46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, nums, new ArrayList<Integer>(), 0);
        return result;
    }
    public void helper(List<List<Integer>> result, int nums[], ArrayList<Integer> temp, int index){
        if(temp.size() == nums.length) {
            result.add(new ArrayList(temp));
        }
        else{
            for(int i=0; i<nums.length;i++){
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                helper(result, nums, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}