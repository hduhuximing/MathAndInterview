package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:44 下午
 * @description
 */
public class Jian63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // int max=0;
        // int curr=prices[0];
        // int sum=0;
        // for(int i=1;i<prices.length;i++){
        //     if(prices[i]<curr){
        //         curr=prices[i];
        //     }else{
        //         sum=prices[i]-curr;
        //         max=Math.max(sum,max);
        //     }
        // }
        // return max;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(buy + prices[i], sell);
            //只买一次，buy和之前的值无关
            buy = Math.max(-prices[i], buy);
        }
        return sell;
    }
}
