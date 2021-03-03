class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1=m-1,tail2=n-1,ptr = nums1.length-1;
        while(ptr >= 0){
            if(tail1 >=0 && tail2>=0){
                if(nums1[tail1]>nums2[tail2]){
                    nums1[ptr] = nums1[tail1];
                    tail1--;  
                    ptr--;
                }else{
                    nums1[ptr] = nums2[tail2];
                    ptr--;
                    tail2--;
                }
            }else{
                break;
            }
        }
        while(tail2 >=0 && ptr >=0){
            nums1[ptr--] = nums2[tail2--];
        }
    }
}
