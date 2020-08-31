
public class Leet121_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1)
            return 0;
        int buy = prices[0], profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - buy);
            if (prices[i] < buy)
                buy = prices[i];

        }
        return profit;
    }

}