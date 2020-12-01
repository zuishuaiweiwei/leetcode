/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit1(int[] prices) {
        if (prices.length == 0 || prices.length == 1){
            return 0;
        }
        if (prices.length == 2){
            return prices[0] < prices[1] ? prices[1] - prices[0] : 0;
        }
        int [] dp = new int[prices.length + 1];
        int min = prices[0];
        for (int i = 1; i< dp.length ;i++){
            dp[i] = Math.max(dp[i - 1] , prices[i -1] - min);
            min = Math.min(prices[i - 1],min);
        }
        return dp[dp.length - 1];
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1){
            return 0;
        }
        if (prices.length == 2){
            return prices[0] < prices[1] ? prices[1] - prices[0] : 0;
        }
        int pre = 0;
        int min = prices[0];
        for (int i = 0; i< prices.length ;i++){
            pre = Math.max(pre, prices[i] - min);
            min = Math.min(prices[i],min);
        }
        return pre;
    }
}
// @lc code=end

