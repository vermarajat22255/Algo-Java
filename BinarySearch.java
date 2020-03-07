class Main {
  static boolean found = false;
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9};
    System.out.println(binarySearch(arr,0, arr.length-1,99));
  }
  static boolean binarySearch(int arr[], int l, int r, int val){
    if(l<=r){
      int mid = l+(r-l)/2;
      if(arr[mid]>val) binarySearch(arr, l, mid-1, val);
      if(arr[mid]<val) binarySearch(arr, mid+1, r, val);
      if(arr[mid]==val){
        System.out.print("Found At "+mid);
        found = true;
      }
    }
    return found;
  }
}
