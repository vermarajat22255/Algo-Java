  // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    int count=0,k=0;
    ArrayList<Integer> al = new ArrayList<>();
    while(max(arr)!=0){
        int min = min(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                arr[i] = arr[i]-min;
                count++;
            }
        }
        al.add(count);
        count = 0;
        k++;
    }
    int res[] = new int[al.size()];
    int c=0;
    while(c<al.size()){
    res[c] = al.get(c); 
    c++;
    }
    return res;
    }
    static int min(int arr[]){
        int min = 1001;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0 && min>arr[i]) min = arr[i];
        }
        return min;
    }
    static int max(int arr[]){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(max<arr[i]) max = arr[i];
        }
        return max;
    }
