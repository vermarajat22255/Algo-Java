/////////O(n2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        LinkedHashSet<List> hs = new LinkedHashSet<>();
        
        
        for(int i=0;i<nums.length;i++){
            int left =i+1, right =nums.length-1;
            int a  = nums[i];
            if(left<nums.length && !hs.contains(Arrays.asList(a,nums[left], nums[right])) ){

                while(left<right){
                    if(nums[left]+nums[right]+a < 0){
                        left++;
                    }else if(nums[left]+nums[right]+ a > 0){
                        right --;
                    }else{
                        List <Integer> al = new ArrayList<>();
                        al.add(a);
                        al.add(nums[left]);
                        al.add(nums[right]);
                        System.out.println("adding set"+al);
                        hs.add(al);
                        left++;
                    }
                }
            }
        }
        Iterator<List> it = hs.iterator();
        while(it.hasNext()){
            result.add(it.next());
        }
        return result;
    }
}




//Solution 2  remove duplicate not worked

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int i=0; i<nums.length; i++){
            
            getTwoSum(i, nums[i], nums, result);
        }
        System.out.println(result);
        return result;
    }

    static void getTwoSum(int avoid, int target, int arr[], ArrayList<List<Integer>> res ){
        
        int left =0, right=arr.length-1;
        HashSet<Integer[]> hs = new HashSet<>();
        while(left < right){
            
            if(left == avoid) left++;
            if(right == avoid) right--;
            if(arr[left]+arr[right] + target == 0)  {
                Integer val[] = new Integer[]{arr[avoid], arr[left], arr[right]};
                if(!hs.contains(val)){
                    hs.add(val);
                    res.add(Arrays.asList(val));
                }
                left++;
                right--;
            } 
            else if(arr[left] + arr[right] < target)  left++;
            else right--;
        }
    }
}