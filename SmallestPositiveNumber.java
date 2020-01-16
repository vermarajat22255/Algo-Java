*********************************USING TREE SET IS INEFFICIENT*********************************** 
import java.util.*;
class Solution {
    
    public int firstMissingPositive(int[] nums) {
    
    TreeSet<Integer> ts = new TreeSet();
    int max=1;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            ts.add(nums[i]);
        }
    }
        int s=0;
        if(ts.size()<1 || ts.first()>1){
            return max;
        }
        while(s<ts.size()){
            if(ts.contains(max))
            {
                ++s;
                ++max;
            }
            else{
                break;
            }
        }
        return max;
    }
}
*********************************USING HASH SET IS MORE EFFICIENT*********************************

import java.util.*;
class Solution {
    
    public int firstMissingPositive(int[] nums) {
    
    HashSet<Integer> hs = new HashSet();
    int max=1;
    for(int i=0;i<nums.length;i++){
        if(nums[i]>0){
            hs.add(nums[i]);
        }
    }
        int s=0;
        if(hs.size()<1){
            return max;
        }
        while(s<hs.size()){
            if(hs.contains(max))
            {
                ++s;
                ++max;
            }
            else{
                break;
            }
        }
        return max;
    }
}
