/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length;i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length ; i++){
            max = max < dp[i] ? dp[i] : max;
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
            int max = nums[0];
            int currentMax = nums[0];

        for (int i = 1; i < nums.length;i++){
            currentMax = nums[i] < currentMax + nums[i] ? currentMax + nums[i] : nums[i];
            max = Math.max(currentMax,max);
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
      return process(0,nums.length -1 ,nums);

    }
    
    public int process(int start, int end,int [] nums){
        if  (start == end ){
            return nums[start];
        }
        int mid = (start + end ) / 2;

        int leftMax = process(start,mid,nums);
        int rigthMax = process(mid + 1,end,nums);

        int midLeft = Integer.MIN_VALUE;
        int midLeftSum = 0;
        int midRight = Integer.MIN_VALUE;
        int midRightSum = 0;
        for( int i = mid ; i >= start; i --){
            midLeftSum += nums[i];
            midLeft = Math.max(midLeft, midLeftSum);
        }

        for( int i = mid + 1; i <= end ; i++){
            midRightSum += nums[i];
            midRight = Math.max(midRight, midRightSum);
        }

        int midMax = midLeft + midRight;
        return Math.max(Math.max(midMax,leftMax),rigthMax);
    }
    
}
// @lc code=end

