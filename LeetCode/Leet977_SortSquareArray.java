// -7,-3,2,3,11
/*
The thing is to divide the array from the point of positive and negatives
Compare the values from that point and pick the smaller one and adjust the pointer.
 */
class Leet977_SortSquareArray {
    public int[] sortedSquares(int[] A) {
      int i=0;
        int ans[] = new int[A.length];
        while(i<A.length){
            if(A[i]>0) break;  
            i++;
        }
        int right = i;
        int left = i-1;
        int k=0;
        while(left >=0 && right < A.length){   
            if(A[left]*A[left] < A[right]*A[right]){
                ans[k] = A[left]*A[left];
                left--;
            }
            else{
                ans[k] = A[right]*A[right];
                right++;
            }
            k++;
        }
        while(left >= 0){
            ans[k] = A[left]*A[left];
            left--;
            k++;
        }
        while(right < A.length){
            ans[k] = A[right]*A[right];
            right++;
            k++;
        }
    
        return ans;
    }
}