public class GetMin{

     public static void main(String []args){
        int prices[] = {310,315, 275, 295, 260, 270, 290, 230, 255, 250};
        int profit = Integer.MIN_VALUE;
        for(int i=0; i<prices.length-1; i++){
            for(int j=i+1; j<prices.length; j++ ){
                int temp = prices[j] - prices[i];
                if(temp>0 && (profit < temp)){
                    profit = temp;
                }
            }    
        }
        System.out.println(profit); 
     
         // Differnce of current entry and min value seen so far
	// O(n) Complexity        
	int profit1 = Integer.MIN_VALUE;
        int min = prices[0];
        
        for(int k=0; k<prices.length; k++){
            if(prices[k] - min > profit1)  profit1 = prices[k] - min;
            if(min > prices[k]) min = prices[k];
        }
        System.out.println(profit); 
     }
}
