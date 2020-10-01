class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        int next = sumOfSquares(n); 
        while(true){
            if(next == 1) return true;
            if(!seen.contains(next)){
                seen.add(next);
                next = sumOfSquares(next);
            }
            else return false;
        }
    }
    public int sumOfSquares(int n){
        int sum = 0;
        while(n > 0){
            int x = n%10;
            x *= x;
            sum += x;
            n = n/10;
        }
        return sum;
    }
}
