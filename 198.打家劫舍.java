/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob1(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if  (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }

        int [] dp = new int[nums.length + 2];

        for (int i = 2; i < dp.length ;i++){
            dp[i] = Math.max(dp[i - 2] + nums[i -2],dp [i - 1]);
        }
        return dp[dp.length - 1];
    }

        public int rob2(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if  (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int res = 0;
        int pre = Math.max(nums[0],nums[1]);
        int pre_pre = nums[0];
        for (int i = 2; i < nums.length ;i++){
            res = Math.max(pre_pre + nums[i],pre);
            pre_pre = pre;
            pre = res;
        }
        return res;
    }
        public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if  (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int [] dp = new int[3];
        dp [0] = nums[0];
        dp [1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length ;i++){
            dp[i % 3] = Math.max(dp [(i - 2) % 3] + nums[i],dp [ (i - 1) % 3]);
        }
        return dp[(nums.length - 1 )% 3];
    }
}
// @lc code=end

