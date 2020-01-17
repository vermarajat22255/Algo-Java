public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        ArrayList<ArrayList> seq = new ArrayList(n);
        ArrayList<Integer> l = new ArrayList();
        int lastAnswer = 0;
        for(int i=0;i<n;i++){
            seq.add(new ArrayList());
        }
        for(int i=0;i<queries.size();i++){
            ArrayList que = (ArrayList) queries.get(i);
            int query =(int) que.get(0);
            int x = (int) que.get(1);
            int y = (int) que.get(2);
            int s;
            if(query == 1){
                s = (x^lastAnswer)%n;
                seq.get(s).add(y);
            }
            else{
                s = (x^lastAnswer)%n;
                int ele = y%seq.get(s).size();
                lastAnswer = (int) seq.get(s).get(ele);
                l.add(lastAnswer);
                System.out.println(lastAnswer);
            }
        }
//        System.out.print(seq);
        return l;
    }

LIST OF LIST DYNAMIC ARRAY.
