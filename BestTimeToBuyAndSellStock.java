public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int num : prices) {
            min = Math.min(min, num);
            profit = Math.max(profit, num - min);
        }
        return profit;
    }
}