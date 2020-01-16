3 part...
Pehle first city se nearest station ka distance.
Dusra 2 station ke bich me max. distance kitna hora/2
3rd last station se last city ka distance.

      // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        int temp[] = new int [c.length+1];
        int a[] = new int[n];
        int ci=1;
        int count=0;
        boolean flag=true;
        for(int i=0;i<n;i++){
            a[i]=i;
        }
        Arrays.sort(c);
        for(int i=0;i<c.length;i++){
            a[c[i]] = -1;
        }
        temp[0] = c[0];
        for(int i=c[0]+1;i<n;i++){
            if(a[i]>=0){
                count++;
                flag=true;
            }
            else{
                count++;
                temp[ci]=count/2;
                ci++;
                count=0;
                flag = false;
            }
        }
        if(flag){
            temp[ci] = count;
        }
        int max = temp[0];
        temp[temp.length-1] = n - c[c.length-1]-1;
        for(int i=0;i<=c.length;i++){
            System.out.println(temp[i]);
            if(max<temp[i]){
                max = temp[i];
            }
        }
        return max;
    }




.......................................................Same question Much better code using 3 part approach..................
// Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int max = c[0];
        for(int i=1;i<c.length;i++){
            if((c[i]-c[i-1])/2 > max)
            max = (c[i]-c[i-1])/2;
        }
        int temp = n-1-c[c.length-1];
        System.out.print(temp);
        if(temp>max) max =temp;
        return max;
    }
