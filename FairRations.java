    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int sum=0,i=0,count=0;
        while(i<B.length){
            sum+=B[i];
            i++;
        }
        if(sum%2!=0) {System.out.println("NO"); return 0;}
        else{
            if(B[0]%2 != 0){
                B[0]+=B[0]+1;
                B[1]+=B[1]+1;
                count+=2;
            }
            for(int j=1;j<B.length-1;j++){
                if(B[j]%2 != 0){
                    B[j]=B[j]+1;
                    B[j+1]=B[j+1]+1;
                    count+=2;
                }
            }
        }
        return count;
    }
