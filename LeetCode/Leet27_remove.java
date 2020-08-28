class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == val){ 
                nums[i] = Integer.MAX_VALUE;
                count++;
            }
        }
        Arrays.sort(nums);
        return nums.length-count;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0, count=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val) {
                nums[j]=nums[i];
                j++;
            }
            else count++;
        }
        return nums.length-count;
    }
}