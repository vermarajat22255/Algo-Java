// Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int beautiful=0;
        for(int a=i;a<=j;a++){
            if(mod(a-rev(a))%k==0) beautiful++;
        }
        return beautiful;
    }
    static int mod(int a){
        return a<0?-a:a;
    }
    static int rev(int a){
        String temp = ""+a;
        String rev="";
        int i=temp.length()-1;
        while(i>=0){
            rev+=temp.charAt(i);
            i--;
        }
        return Integer.parseInt(rev);
    }
