******Using System.arraycopy(source, sourceIndex, Dest, DestIndex, NumberOfElements);
  
  public static void main(String[] args) {

    public static int[] rotateArray(int[] arr, int d){
    // Because the constraints state d < n, we need not concern ourselves with shifting > n units.
    int n = arr.length;

    // Create new array for rotated elements:
    int[] rotated = new int[n]; 
    // Copy segments of shifted elements to rotated array:
    System.arraycopy(arr,0,rotated,n-d,d);
    System.arraycopy(arr,d,rotated,0,n-d);
    return rotated;
    }
  }
  
  
  //Can be done better through String operations
