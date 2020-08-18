import java.util.Arrays;
public class MinImpossibleSum{

     public static void main(String []args){
        // return the smallest change not possible with the given coins
        int[] coins = {1,1,1,1,1,5,10,25};
        
        Arrays.sort(coins);
        if(coins[0] > 1) {
            System.out.println(1);
            return;
        }
        
        int sum = coins[0];
        
        for(int i=1; i<coins.length ;i++){
            if(coins[i]<= sum){
                sum = sum + coins[i];
            }
            else {
                System.out.println(sum+1);
                break;
            }
        }
     }
}