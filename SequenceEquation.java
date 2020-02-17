    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int res[] = new int[p.length];
        int k=0;
        for(int x=0;x<p.length;x++){
        for(int i=0;i<p.length;i++){
            if(x+1 == p[i]){
              for(int j=0;j<p.length;j++){
                if(p[j]==i+1){
                res[k] = j+1;
                k++;
                }
              }
            }
        }
        }
        return res;
    }
// The challenging thing in this question is to track the index, we will need three loops, every time we check a value is a index.
// complexity will be O(n3)
