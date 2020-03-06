class Main {
  public static void main(String[] args) {
  int arr[] =  {1,5,3,7,2};//{5, 3, 7, 2, 6, 4, 5, 9, 1, 2};
  System.out.println("Calculated -> " +calculateWater(arr));
  }
  public static int calculateWater(int arr[]){
    int collected = 0;
    //left to right
    int temp =0;
    int i =1,j=0; 
    while(i< arr.length){
      if(arr[j]-arr[i]>0){
        temp += arr[j] - arr[i];
      }else{
        j = i;
        collected += temp;
        temp = 0;
      }
      i++;
    }
    System.out.println("Collected from left"+ collected);
    //right to left
    temp = 0;
    i =arr.length-2;j=arr.length-1;
    while(i> 0){
      if(arr[j]-arr[i]>0){
        temp += arr[j] - arr[i];
      }else{
        j = i;
        collected += temp;
        temp = 0;
      }
      i--;
    }
    return collected;
  }
}
