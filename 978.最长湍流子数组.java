/*
 * @lc app=leetcode.cn id=978 lang=java
 *
 * [978] 最长湍流子数组
 */

// @lc code=start
class Solution {
    public int maxTurbulenceSize(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        if(nums.length == 2){
            return nums[0] == nums[1] ? 1: 2;
        }
        int [] dp = new int[nums.length];
        dp[1] = nums[0] == nums[1] ? 1 : 2;
        int max = 0;
        for (int i = 2;i < nums.length ; i++){
            if((nums[i - 2] > nums[i -1] && nums[i - 1] < nums[i] ) || (nums[i - 2] < nums[i - 1] && nums[i - 1] > nums[i]) ){
                dp[i] = dp[i - 1] + 1;
            }else if(nums[i] != nums[i - 1]){
                dp[i] = 2;
            }else{
                dp[i] = 1;
            }           
            max = Math.max(max,dp[i]);

        }
       return max; 
    }
}
// @lc code=end

