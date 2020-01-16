   // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        int sum[] = new int[16];
        int f=0;
        for(int l=0;l<4;l++){
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    if(j==1 && (k==0 || k==2))
                    {}
                    else
                    sum[f]=sum[f]+arr[j+l][k+i];
                }
            }
            f++;
        }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<sum.length;i++){
            if(sum[i]>=max)
            max=sum[i];
        }
return max;
    }

