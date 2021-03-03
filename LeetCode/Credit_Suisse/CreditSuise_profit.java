public class CreditSuise_profit {
    public static void main(String[] args) {
        int profit[] = new int[]{3, 1,2,1,4,5};//{3,6,9,8,2,4 };
        int values[] = new int[]{3,2};
        System.out.println(findMinDays(values, profit));
    }
    public static String findMinDays(int[] values, int[] profit) {
        String result = "";
        if(profit.length < 2) return result;
        for(int i=0; i< values.length; i++)
            result += getMin(values[i], profit)+",";
        return result.substring(0, result.length()-1);
    }
    public static String getMin(int target, int profit[]){
        int min_diff = Integer.MAX_VALUE;
        String res = "-1";
        int prev_end = Integer.MAX_VALUE;

        for(int i=1; i<profit.length; i++){
            int left = i-1, right = i;
            while(right < profit.length){
                if(profit[right] - profit[left] == target){
                    if(min_diff >= right-left && right <= prev_end ){
                        min_diff = right-left;
                        prev_end = right;
                        res = (left+1)+" "+(right+1);
                        System.out.println(profit[left] +" and "+ profit[right]);
                    }
                    // break;
                }

                right++;
            }
        }
        return res;
    }
}
// andrea muscadin
//abe dias
// miranda lewis