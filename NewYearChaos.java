// Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int count=0;
        for(int i=q.length-2;i>=0;i--){
        int ptr = i;
        int temp;
        for(int k=0;k<2;k++){
            if((i+1 <= q.length-1) && q[i]>q[i+1] ){
                temp = q[i];
                q[i]= q[i+1];
                q[i+1] = temp;
                count++;
                i++;
            }
        }

        }
         
       if(check(q) =="") System.out.println(count);
       else System.out.println("Too chaotic");
    }
    static String check(int[] q){
        for(int i=0;i<=q.length-2;i++){
            if(q[i]>q[i+1]){
            return "Too chaotic";
            }
        }
        return "";
    }
