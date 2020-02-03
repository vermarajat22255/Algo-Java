    static int minimumAbsoluteDifference(int[] arr) {
        int n1=Integer.MAX_VALUE;
        Arrays.sort(arr);
        n1 = Math.min(mod(arr[arr.length-1]-arr[arr.length-2]),mod(arr[0]-arr[1]));
        for(int i=2;i<arr.length-1;i++){
        n1 = Math.min(n1,mod(arr[i-1]-arr[i]));    
        }
        return n1;
    }
    static int mod(int n){
        return n>=0?n:-n;
    }
