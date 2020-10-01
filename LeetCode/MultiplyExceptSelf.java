class MultiplyExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        
        int output[] = new int[nums.length];
        output[0] = 1;
        // all before ith
        for(int i=1; i<nums.length; i++){
            output[i] =  output[i-1]*nums[i-1];
        }
        
        
        // 1 1 2 6
        int output1[] = new int[nums.length];
        output1[output1.length-1] = 1;
        
        for(int i=nums.length-2; i >=0; i--){
            output1[i] =  output1[i+1]*nums[i+1];
        }
        int result[] = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = output[i]*output1[i];
        }
        return result;
    }
}
