class Arr_duplicateZero {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == 0)
                zeros++;
        }
        if(zeros == 0) return;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] == 0){
                arr = rightShift(arr, i, arr.length-1);
                i++;
            }
        }
    }
    public int[] rightShift(int arr[], int start, int end){
        for(int i = end; i>start; i--){
            arr[i] = arr[i -1];
        }
        return arr;
    }
}