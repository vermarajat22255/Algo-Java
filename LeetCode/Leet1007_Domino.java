class Leet1007_Domino {
    public int minDominoRotations(int[] A, int[] B) {
        int count = 0;
        int result = Integer.MAX_VALUE;
        boolean isASort = true, isBSort = true;
        
        for(int value=1; value<=6; value++){
            int ASortCount = 0;
            for(int j=0; j<A.length; j++){
                if(A[j] != value){
                    if(B[j] != value){
                        count = 0;
                        break;
                    }else{
                        count++;
                    }
                }else{
                    ASortCount++;
                }
            }
            if(ASortCount == A.length) {
                return 0;
            }
            if(count != 0)
                result = Math.min(result, count);
        }
        
        for(int value=1; value<=6; value++){
            count = 0;
            int BSortCount = 0;
            for(int k=0; k<B.length; k++){
                if(B[k] != value){
                    if(A[k] != value){
                        count = 0;
                        break;
                    }else{
                        count++;
                    }
                }else{
                    BSortCount++;
                }
            }
            if(BSortCount == B.length) {
                return 0;
            }
            if(count != 0)
                result = Math.min(result, count);
        }
         
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
