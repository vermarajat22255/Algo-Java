// Complete the breakingRecords function below.
    static int max,min,maxCount,minCount;
    static int[] breakingRecords(int[] scores) {
        max=min=scores[0];
        maxCount=0;
        for(int i=0;i<scores.length;i++){
            if(scores[i]>max){
                max = scores[i];
                maxCount++;
            }
            else if(scores[i]<min){
                min = scores[i];
                minCount++;
            }
        }
        int res[] ={maxCount,minCount};
        return res;
    }
