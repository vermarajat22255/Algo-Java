class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(int x: nums1) pq.add(Double.valueOf(x));
        for(int y: nums2) pq.add(Double.valueOf(y));
        int idx = pq.size()/2;
        if(pq.size()%2 != 0) {
        while(idx>0){
                pq.poll();
                idx--;
            }
            return pq.peek();
        }else{
            while(idx-1 >0){
                pq.poll();
                idx--;
            }
            if(pq.size()>1) return (pq.poll()+pq.poll())/2;
            return pq.poll();
        } 
    }
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        double result = 0.0d;
        
        int merged[] = new int[nums1.length+nums2.length];
        int i=0, k=0, j=0;
        
        while(i< nums1.length && j<nums2.length){
            if(nums1[i] > nums2[j]){
                merged[k] = nums2[j];
                j++;
            }else{
                merged[k] = nums1[i];
                i++;
            }
            k++;
        }
        if(j < nums2.length){
            while(j < nums2.length){
                merged[k] = nums2[j];
                k++;
                j++;
            }
        }
        else{
            while(i < nums1.length){
                merged[k] = nums1[i];
                k++;
                i++;
            }
        }
        
        if( merged.length % 2 == 0){    
            return new Double(merged[(merged.length/2) - 1] + merged[(merged.length/2)])/2;
        }
        else
            return new Double(merged[(merged.length/2)]);
        
    }
}