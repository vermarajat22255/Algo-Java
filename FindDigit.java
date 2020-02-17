static int findDigits(int n) {
        int count=0, copy=n;
        while(n>0){
            int k = n%10;
            if(k!=0 && copy%k ==0) {
                System.out.println(k);
                count++;
                }
            n=n/10;
        }
    return count;
    }
