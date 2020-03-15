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
}
