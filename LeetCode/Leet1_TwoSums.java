import java.util.*;

public class Leet1_TwoSums {
    public int[] twoSum(int[] nums, int target) {

//********************************************************************* */
        
                    // O(n^2)

//********************************************************************* */

        // for(int i=0; i< nums.length; i++){
        // for(int j=1; j<nums.length; j++){
        // if(i!=j && nums[i]+nums[j] == target){
        // return new int[]{i,j};
        // }
        // }
        // }
        // return new int[]{};
        // }
//********************************************************************* */
        
                    // O(n log n)

//********************************************************************* */
    //     int copy[] = nums.clone();
    //     Arrays.sort(nums);
    //     int highIndex = nums.length - 1;
    //     int lowIndex = 0;

    //     while (lowIndex < highIndex) {
    //         if (nums[lowIndex] + nums[highIndex] == target) {
    //             return indexBySearch(nums[lowIndex], nums[highIndex], copy);
    //         }
    //         if (nums[lowIndex] + nums[highIndex] > target)
    //             highIndex--;
    //         else
    //             lowIndex++;
    //     }

    //     return new int[] {};
    // }

    // int[] indexBySearch(int low, int high, int copy[]) {
    //     int temp[] = new int[2];
    //     int k = 0;
    //     for (int i = 0; i < copy.length; i++) {
    //         if (copy[i] == low || copy[i] == high) {
    //             temp[k] = i;
    //             k++;
    //         }
    //         if (k == 2)
    //             break;
    //     }
    //     return temp;
    // }
//********************************************************************* */
        
                    // O(n log n)

//********************************************************************* */
        
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=0;i<nums.length;i++){
                if(hm.containsKey(target-nums[i]) ){
                    return new int[]{hm.get(target-nums[i]), i};
                }
                hm.put(nums[i],i);
            }
            return new int[]{};
        }
}