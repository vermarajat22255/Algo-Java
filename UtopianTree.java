  // Complete the utopianTree function below.
    static int utopianTree(int n) {
        int height =1,i=1;
        while(i<=n){
            if(i%2!=0){
                height*=2;
            }else{
                height+=1;                
            }
            i++;
        }
    return height;
    }
