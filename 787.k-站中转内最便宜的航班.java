/*
 * @lc app=leetcode.cn id=787 lang=java
 *
 * [787] K 站中转内最便宜的航班
 */

// @lc code=start
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int [][] dp = new int[k+1][n];
        //因为需要求最小值，无用位置初始化为最大值
        for(int i = 0 ; i < dp.length ; i++){
                Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int[] arr:flights){
            if(arr[0] == src){
                for (int[] ints : dp) {
                    //初始化直达位置在k站的费用为直达费用
                    //主要是防止 k 站不能到达，但是可以直达
                    ints[arr[1]] = arr[2];
                }
            }
        }
        for(int i = 1 ; i <= k ; i++){
            for(int j = 0 ;j < flights.length ; j++){
                int srcc = flights[j][0];
                int target = flights[j][1];
                int price = flights[j][2];
                //如果新的起点，在k - 1 的位置有终点，也就是不为初始化的值，那么新的终点就可以在 k 站内到达
                if(dp[i-1][srcc] != Integer.MAX_VALUE){
                    dp[i][target] = Math.min(dp[i-1][srcc] + price , dp[i][target]);
                }
            }

        }
        return dp[k][dst] == Integer.MAX_VALUE ? -1 : dp[k][dst];

    }
}
// @lc code=end

