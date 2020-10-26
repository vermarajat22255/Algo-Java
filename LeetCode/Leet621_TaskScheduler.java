class Leet621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0 || tasks.length == 1) return tasks.length;
        //create a map of frequency of task
        // start picking from the most frequent task
        
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: tasks)
            map.put(ch, map.getOrDefault(ch,0)+1);
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(map.values());
        
        int cycles=0;
        
        while(!maxHeap.isEmpty()){ // we still have tasks to do
            // pick the first task and put it in templist
            ArrayList<Integer> temp = new ArrayList<>();
            //keep putting tasks for n slots including this current slot
            for(int i=0; i<n+1; i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.remove()); // Ok, say we doing the most frequent task, 1 by 1
                }
            }
            for(int i: temp){
                if(--i > 0) { //we still need to complete this task more
                    maxHeap.add(i);
                }
            }
            // we need to add the slot by tasks we ran
            // but because at last we dont need additional slots if heap is empty and no task to do 
            cycles += maxHeap.isEmpty() ? temp.size() : n+1;
        }
        return cycles;
    }
}
/*
    n = 2
    A A A A A A B C D E F G
     
     A B C A D E A F G  A X  X   A  X  X  A
     _ _ _ _ _ _ _ _ _  _  _  _  _  _  _  _  
     1 2 3 4 5 6 7 8 9 10 11 12  13 14 15 16
     
     n =2 
     A A A B B B
     
     A B   A B   A B
     _ _ _ _ _ _ _ _
     1 2 3 4 5 6 7 8
*/
 
