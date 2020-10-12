class Leet380_GetRandom {
    ArrayList<Integer> al;
    HashMap<Integer, Integer> hm;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        al = new ArrayList<>();
        hm = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!hm.containsKey(val)){
            hm.put(val, al.size());
            al.add(val);
            return true;
        }
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hm.containsKey(val)){
            // removing from the middle of the arraylist is actually O(n) complexity
            // because it adjusts the elements behinds it, we will swap it with last element
            // and remove the last element
            int lastone = al.get(al.size()-1);
            int indxlast = al.size()-1;
            int currone = val;
            int indxcurr = hm.get(val);
            
            
            al.set(indxlast, currone);
            al.set(indxcurr, lastone);
            hm.replace(lastone, indxcurr);
            al.remove(al.size()-1);
            hm.remove(currone);
            return true;
        }
        return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int rndm = (int) Math.floor(Math.random()*hm.size());
        // System.out.println(al);
        return (int)al.get(rand.nextInt(al.size()) );
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
