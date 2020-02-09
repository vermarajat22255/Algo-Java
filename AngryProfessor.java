static String angryProfessor(int k, int[] a) {
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=0 && count<=k){
                count++;
            }
            if(count == k){
                return "NO";
            }
        }
        return "YES";
    }
