package dp;

/**
 * 买卖股票的最佳时机②
 * LeetCode 122
 * @Author: coffee
 */
public class StockExchange {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange();
        int[] data = {7, 1, 5, 3, 4, 6};
        System.out.println(stockExchange.maxProfit(data));
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length) {
            return 0;
        }
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                }
            }
            if (maxprofit > max) {
                max = maxprofit;
            }
        }
        return max;
    }
}
