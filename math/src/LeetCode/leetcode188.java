package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/3 12:51 下午
 * @description
 */
public class leetcode188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return maxFit(prices);
        }
        int[] sells = new int[k + 1];
        int[] buys = new int[k + 1];
        Arrays.fill(buys, -prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                sells[j] = Math.max(sells[j], buys[j] + prices[i]);
                buys[j] = Math.max(buys[j], sells[j - 1] - prices[i]);
            }
        }
        return sells[k];
    }

    private int maxFit(int[] prices) {
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, prices[i] + buy);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}
