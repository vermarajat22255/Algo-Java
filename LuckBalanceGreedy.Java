    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int sum=0,count=0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<contests.length;i++){
            int luck = contests[i][0];
            int win = contests[i][1];
            if(win == 1){
                count++;
                q.add(luck);
            }else if(win == 0){
                sum+=luck;
            }
        }
        System.out.print("before poll -> "+q);
        for(int i=0;i<count-k;i++){
            sum-=q.poll(); 
        }
        System.out.print("after poll -> "+q+" sum->"+sum);
        
        while(q.peek()!=null){
            sum+=q.poll();
        }
        System.out.println(sum);
        return sum;
    }
