class Leet845_LargestMountain {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;
        int largestMountain = 0;
        int pointer=0;
        int peak=0;
        int end = arr.length;
        
        while(pointer < end){
            int base = pointer;
            
            while(pointer+1 < end && arr[pointer] < arr[pointer+1])
                pointer++;
            
            if(base == pointer){
                pointer++;
                continue;
            }   
            peak = pointer;
            
            while(pointer+1 < end && arr[pointer]>arr[pointer+1]) 
                pointer++;
            if(peak == pointer){
                pointer++;
                continue;
            }
            largestMountain = Math.max(largestMountain, pointer-base+1);
        }
        return largestMountain;
    }
}
