
//O(n2) brute force///
class Solution {
    public int maxArea(int[] height) {
        int max =0,sum=0;
        for(int i=0;i<height.length;i++){
            for(int j= height.length-1; j>=i; j--){
                sum = water(height, i, j);
                max = sum>max?sum:max;
            }
        }
        return max;
    }
    public int water(int height[], int i, int j){
        return (Math.abs(j-i)*Math.min(height[i],height[j]));
    }
}
//////////////////Two pointers/////////
/* We start with highest width rectangle to get the maximum area, but the length of the shorter line can decrease the area so we move left of right pointer by 1 whichever line is shorter with a hope to get the bigger line that will increase the area.*/

class Solution {
    public int maxArea(int[] height) {

        int max = 0,sum = 0, left = 0, right = height.length-1;
        while(left<right){
            sum = water(height, left, right);
            max = sum > max?sum:max;
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
    public int water(int height[], int i, int j){
        return (Math.abs(j-i)*Math.min(height[i],height[j]));
    }
}
