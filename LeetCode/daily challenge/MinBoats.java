class MinBoats {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int right=people.length-1;
        int left=0;
        while(left <= right){
            if(people[left]+people[right] <= limit){
                left++;
                right--;
                boats++;
            }else{
                right--;
                boats++;
            }
        }
        return boats;
    }
}
