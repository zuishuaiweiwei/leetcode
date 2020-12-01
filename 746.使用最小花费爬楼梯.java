/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 2){
            return 0;
        }
        int pre = 0;
        int pre_pre=0;
        for(int i = 0 ; i < cost.length ; i++){
            int temp = pre;
            pre = Math.min(pre,pre_pre) + cost[i];
            pre_pre = temp;
        }
        return Math.min(pre,pre_pre);
    }
}
// @lc code=end

