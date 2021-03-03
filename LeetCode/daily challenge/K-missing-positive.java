class K-missing-positive {
    public int findKthPositive(int[] arr, int k) {
        if(arr[0] > k) return k;


        int total_miss = arr[0]-1, prev = 0;
        for(int i=1;i<arr.length; i++){
            
            prev = total_miss; // 8
            total_miss += arr[i]-arr[i-1]-1; // 18
            if(total_miss >= k){
                return arr[i-1]+Math.abs(k-prev);
            }
        }
        if(total_miss == 0) return arr[arr.length-1]+k;
        if(total_miss >= k) return arr[arr.length-2]+Math.abs(k-prev);
        return arr[arr.length-1]+(k-total_miss);
    }
}
