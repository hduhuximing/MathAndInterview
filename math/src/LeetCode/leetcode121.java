package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/5 8:16 下午
 * @description
 */
public class leetcode121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}
